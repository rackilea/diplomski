mLooperThread = new LooperThread();
mLooperThread.start();
synchronized (mLooperThread) {
  while (null == mLooperThread.mHandler) {
    mLooperThread.wait();
  }
}
mLooperThread.mHandler.postDelayed(r , 5000);