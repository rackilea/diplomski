public void run() {
    int i = 0;

    while (++i <= 5) {
        // let a chance for other threads
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            sum = i;
            try {
                sleep(1000);
                System.out.println("Woke up from sleep");
                if (i >= 2) {
                    notify();                   
                }

            } catch (InterruptedException ie) {
                ie.printStackTrace();
                System.exit(1);
            }
        }
    }
}