boolean running = true; // flag for keeping the thread running

while (running) {
    try {
        synchronized (tempDestinations) {
            if (upDestinations.isEmpty() && downDestinations.isEmpty()){
                tempDestinations.wait();
            }
        }
        if (!downDestinations.isEmpty()) {
            processDownRequest();
        }
        else if (!upDestinations.isEmpty()) {
            processUpRequest();
        }
    }
    catch (InterruptedException ex) {
        System.out.println("Interrupted! Going back to check for " +
                "requests/wait");
    }
}