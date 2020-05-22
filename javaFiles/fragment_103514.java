public class SendToQueue {
private final ExecutorService cleanupExecutor = Executors.newFixedThreadPool(5);
private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

// Not sure why you are using a cache rather than a standard ConcurrentHashMap?
private final Cache<Long, PendingMessage> cache = CacheBuilder.newBuilder().maximumSize(1000000)
    .concurrencyLevel(100)
    .removalListener(RemovalListeners.asynchronous(new LoggingRemovalListener(), cleanupExecutor)).build();

private static class PendingMessage {
    private final long _address;
    private final byte[] _encodedRecords;
    private final Socket _socket;
    private final boolean _retryEnabled;
    private final Object _monitor = new Object();
    private long _sendTimeMillis;
    private volatile boolean _acknowledged;

    public PendingMessage(long address, byte[] encodedRecords, Socket socket, boolean retryEnabled) {
        _address = address;
        _sendTimeMillis = System.currentTimeMillis();
        _encodedRecords = encodedRecords;
        _socket = socket;
        _retryEnabled = retryEnabled;
    }

    public synchronized boolean hasExpired() {
        return System.currentTimeMillis() - _sendTimeMillis > 500L;
    }

    public synchronized void markResent() {
        _sendTimeMillis = System.currentTimeMillis();
    }

    public boolean shouldRetry() {
        return _retryEnabled && !_acknowledged;
    }

    public boolean waitForAck() {
        try {
            synchronized(_monitor) {
                _monitor.wait(500L);
            }
            return _acknowledged;
        }
        catch (InterruptedException e) {
            return false;
        }
    }

    public void ackReceived() {
        _acknowledged = true;
        synchronized(_monitor) {
            _monitor.notifyAll();
        }
    }

    public long getAddress() {
        return _address;
    }

    public byte[] getEncodedRecords() {
        return _encodedRecords;
    }

    public Socket getSocket() {
        return _socket;
    }
}

private static class Holder {
    private static final SendToQueue INSTANCE = new SendToQueue();
}

public static SendToQueue getInstance() {
    return Holder.INSTANCE;
}

private void handleRetries() {
    List<PendingMessage> messages = new ArrayList<>(cache.asMap().values());
    for (PendingMessage m : messages) {
        if (m.hasExpired()) {
            if (m.shouldRetry()) {
                m.markResent();
                doSendAsync(m, m.getSocket());
            }
            else {
                // Or leave the message and let send remove it
                cache.invalidate(m.getAddress());
            }
        }
    }
}

private SendToQueue() {
    executorService.submit(new ResponsePoller()); // another thread which receives acknowledgement and then delete entry from the cache accordingly.
    executorService.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            handleRetries();
        }
    }, 0, 1, TimeUnit.SECONDS);
}

public boolean sendAsync(final long address, final byte[] encodedRecords, final Socket socket) {
    PendingMessage m = new PendingMessage(address, encodedRecords, socket, true);
    cache.put(address, m);
    return doSendAsync(m, socket);
}

private boolean doSendAsync(final PendingMessage pendingMessage, final Socket socket) {
    ZMsg msg = new ZMsg();
    msg.add(pendingMessage.getEncodedRecords());
    try {
        // send data on a socket LINE A
        return msg.send(socket);
    }
    finally {
        msg.destroy();
    }
}

public boolean send(final long address, final byte[] encodedRecords, final Socket socket) {
    PendingMessage m = new PendingMessage(address, encodedRecords, socket, false);
    cache.put(address, m);
    try {
        if (doSendAsync(m, socket)) {
            return m.waitForAck();
        }
        return false;
    }
    finally {
        // Alternatively (checks that address points to m):
        // cache.asMap().remove(address, m);
        cache.invalidate(address);
    }
}

public void handleAckReceived(final long address) {
    PendingMessage m = cache.getIfPresent(address);
    if (m != null) {
        m.ackReceived();
        cache.invalidate(address);
    }
}
}