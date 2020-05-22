Runnable myRunnable = new Runnable(){
  public void run(){
    int a = 1000;
    a     = a * 200;
  }
}

Thread myThread = new Thread(myRunnable);
myThread.start();
myThread.join();