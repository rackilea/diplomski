public synchronized void start() {
        /**
         * This method is not invoked for the main method thread or "system"
         * group threads created/set up by the VM. Any new functionality added
         * to this method in the future may have to also be added to the VM.
         *
         * A zero status value corresponds to state "NEW".
         */
        if (threadStatus != 0)
            throw new IllegalThreadStateException();
        group.add(this);
        start0();
        if (stopBeforeStart) {
            stop0(throwableFromStop);
        }
    }

private native void start0(); // Native code is not here but this method will call run() method

public void run() {
    if (target != null) {
        target.run();
    }
}