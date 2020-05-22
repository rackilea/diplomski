try {
            runner = Thread.currentThread();
            if (getState() == RUNNING)
                callable.call(); // don't set result
            runner = null;
            return compareAndSetState(RUNNING, 0);
        } catch (Throwable ex) {
            innerSetException(ex);
            return false;
        }