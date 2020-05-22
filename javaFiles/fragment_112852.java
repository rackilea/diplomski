synchronized (this) {
    while (++i <= 5) {
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