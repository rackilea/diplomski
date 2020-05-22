new Thread(new Runnable() {
        @Override
        public void run() {
            lance(); // call your network method here
        }
    }).start();