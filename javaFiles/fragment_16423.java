static class Stream {
    private long position = 0L;

    void setPosition(long position) {
        this.position = position;
    }
}

final static class StreamInfo {
    final Stream stream = new Stream();
    volatile long resumePosition = -1;

    final void setPosition(final long position) {
        stream.setPosition(position);
        resumePosition = position;
    }
}

private final Object updateLock = new Object();
private final AtomicReference<StreamInfo> currentInfo = new AtomicReference<>(new StreamInfo());

void f1() {
    synchronized (updateLock) {
        final StreamInfo oldInfo = currentInfo.getAndSet(null);
        final StreamInfo newInfo = new StreamInfo();

        if (oldInfo != null && oldInfo.resumePosition > 0L) {
            newInfo.setPosition(oldInfo.resumePosition);
        }

        // Only `f2` can modify `currentInfo`, so update it last.
        currentInfo.set(newInfo);

        // The `f2` thread might be waiting for us, so wake them up.
        updateLock.notifyAll();
    }
}

void f2(final long newPosition) {
    while (true) {
        final StreamInfo s = acquireStream();

        s.setPosition(newPosition);
        s.resumePosition = newPosition;

        // Make sure the stream wasn't replaced while we worked.
        // If it was, run again with the new stream.
        if (acquireStream() == s) {
            break;
        }
    }
}

private StreamInfo acquireStream() {
    // Optimistic concurrency: hope we get a stream that's ready to go.
    // If we fail, branch off into a slower code path that waits for it.
    final StreamInfo s = currentInfo.get();
    return s != null ? s : acquireStreamSlow();
}

private StreamInfo acquireStreamSlow() {
    synchronized (updateLock) {
        while (true) {
            final StreamInfo s = currentInfo.get();

            if (s != null) {
                return s;
            }

            try {
                updateLock.wait();
            }
            catch (final InterruptedException ignored) {
            }
        }
    }
}