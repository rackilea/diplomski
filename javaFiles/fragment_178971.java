Runnable commTask = () -> {
    // volatile boolean controlled from the GUI
    while(deviceConnection) {
        // retrieve start time
        startTime = System.nanoTime();
        // time since commProtocol was last called
        timeDiff = startTime - previousTime;

        // if at least 5 milliseconds has passed
        if(timeDiff >= 5000000) {
            // handle communication
            commProtocol();
            // store the start time for comparison
            previousTime = startTime;
        }
        Thread.yield();
    }
};

// commTask is started as follows
service = Executors.newSingleThreadScheduledExecutor();
service.execute(commTask);