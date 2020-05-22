public void moreAccurateTimer(int period) { // Sleep time in
                                                // milliseconds
        long beforeTime, timeDiff, sleepTime;
        beforeTime = System.currentTimeMillis();
        boolean running = true;
        while (running) {
            doStuff();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleepTime = period - timeDiff;

            if (sleepTime <= 0L) { // Even if doing stuff took longer than
                                    // period
                sleepTime = 5L; // sleep some anyway
            }

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }

            beforeTime = System.currentTimeMillis();
        }
    }