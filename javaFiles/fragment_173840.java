long start = System.currentTimeMillis();
    while(System.currentTimeMillis() < start + 10000) { //testing with 10 seconds

        int wait = getWaitingPeriod(start, start + 10000, 1, 0.3);
        System.out.println("waiting " + wait + "ms");
        try {
            Thread.sleep(wait);
        } catch(InterruptedException ex) {}

    }