class mythread extends Thread {
Runnable pre = new Runnable() {
                    @Override
                    public void run() {
                      //Do Stuff on UI Thread
                      synchronized (this) {
                            this.notify();
                      }
                    }
}
Runnable post = new Runnable() {
                    @Override
                    public void run() {
                      //Do Stuff on UI Thread
                      synchronized (this) {
                            this.notify();
                      }
                    }
}
Runnable doinbackground = new Runnable() {
                    @Override
                    public void run() {
                      //Do Stuff on separate thread
                    }
}
synchronized (pre) {
   runOnUiThread(pre);
   try {
      pre.wait();
   } catch (Exception e) {
      e.printStackTrace();
   }
}
doninbackground.run();
synchronized (post) {
   runOnUiThread(post);
   try {
      post.wait();
   } catch (Exception e) {
      e.printStackTrace();
   }
}
}
Executor singleThreadExecutor = Executors.newSingleThreadExecutor();
singleThreadExecutor.execute(new mythread());
singleThreadExecutor.execute(new mythread());