mTicker = new Runnable() {
        public void run() {

         //user interface interactions and updates on screen

           mHandler.postDelayed(mTicker, 1000);

        }
    };
    mTicker.run();