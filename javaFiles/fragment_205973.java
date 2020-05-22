Thread updater = new Thread(() -> {
        while (true) {
            updateYourTable();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    updater.start();