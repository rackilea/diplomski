public synchronized void stop() {
        stateHolder.set(State.STOPPING);
        wakeupSelector();

        // we prefer Selector thread shutdown selector
        // but if it's not running - do that ourselves.
        if (runnerThreadActivityCounter.compareAndSet(0, -1)) {
             // The thread is not running
            shutdownSelector();
        }
    }