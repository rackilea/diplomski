static const int STATE_UNLOCKED = 0;
static const int STATE_READING = 1;
static const int STATE_WRITING = 2;
int state = STATE_UNLOCKED;
int readers = 0;
Queue<CompletableFuture<Void>> queueWriters = new LinkedList<CompletableFuture<Void>>();
Queue<CompletableFuture<Void>> queueReaders = new LinkedList<CompletableFuture<Void>>();

public synchronized CompletionStage<Void> lockWriter() {
    CompletableFuture<Void> l = new CompletableFuture<Void>();
    if (state == STATE_UNLOCKED) {
        state = STATE_WRITING;
        l.complete(null);
        return l;
    }
    queueWriters.offer(l);
    return l;
}

public synchronized CompletionStage<Void> lockReader() {
    CompletableFuture<Void> l = new CompletableFuture<Void>();
    if (state != STATE_WRITING) {
        state = STATE_READING;
        readers++;
        l.complete(null);
        return l;
    }
    queueReaders.offer(l);
    return l;
}

public void unlock() {
    CompletableFuture<Void> l = null;
    synchronized(this) {
        if (state == STATE_READING) {
            readers--;
            if (readers > 0) {
                return;
            }
        }
        l = queueReaders.poll();
        if (l != null) {
            state = STATE_READING;
            readers++;
        }
        else {
            l = queueWriters.poll();
            if (l != null) {
                state = STATE_WRITING;
            }
            else {
                state = STATE_UNLOCKED;
                return;
            }
        }
    }
    l.complete(null);
    while (true) {
        synchronized (this) {
            if (state != STATE_READING) {
                return;
            }
            l = queueReaders.poll();
            if (l == null) {
                return;
            }
            readers++;
        }
        l.complete(null);
    }
}