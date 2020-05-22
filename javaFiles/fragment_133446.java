Runnable r = new Runnable() {
    public void run() {
         playPlayerCard();
    }
};

mHandler.postDelayed(r, 500);