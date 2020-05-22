mBackgroundHandler.post(new Runnable() {

    @Override
    public void run() {
        //Do background operation in synchronous manner as usual.

    mMainHandler.post(new Runnable() {
        @Override
        public void run() {
            //Remove loader, update UI
        }
    });
  }
});