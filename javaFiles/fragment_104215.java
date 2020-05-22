public void run() {
    while (running) {
        try {
            LOGGER.debug("Doing some real work ,like Counting...");
            for(int i=0;i<100;i++){}

        } catch (InterruptedException e) {
            LOGGER.error("Exception", e);
            running = false;
        }           
    }
    //Clean up
}