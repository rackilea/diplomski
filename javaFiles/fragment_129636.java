Handler mHandler;
   public Handler getHanlder() {

        if (mHandler == null) {
            mHandler = new MyHandler();
        }
        return mHandler;
    }