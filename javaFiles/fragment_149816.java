public void run() {
    while (true) {
        // check feeds here   <<<---- Look for the bug here
        try {
            Thread.sleep(600000);
        } catch (InterruptedException ex) {
            // exception handing
        }
    }
}