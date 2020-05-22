t = new Thread() {
    public void run() {
            try {
                sleep(5*60*1000);
                // Wipe your valuable data here
                System.exit(0);
            } catch (InterruptedException e) {
                return;
            }
    }.start();
}