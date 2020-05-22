synchronized (sync) {
        for (int i = 0; i < 10; i++) {
            sync.print(s);
            // I have done my bit, wake other threads.
            sync.notifyAll();
            try {
                // give up the lock and let another thread run.
                sync.wait(10);
            } catch(InterruptedException ie) {
                throw new AssertionError(ie);
            }
        }
    }