new Thread(new Runnable() {
        public void run() {
            try {
                Thread.sleep(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startActivity(myintent);
            finish();
        }
    }).start();