new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                // Code here
            }
        }
    }).start();