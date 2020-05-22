Thread r = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                    System.exit(0);
                } catch (InterruptedException e) {
                }
            };
        };
        r.start();