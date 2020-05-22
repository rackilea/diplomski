final AtomicBoolean pass = new AtomicBoolean(false); //making this final means we can access it in the anonymous Thread instance
Thread simpleThread=new Thread(){
  public void run(){
    x=doStuff();
    if (x==0) pass.set(true);
  }
}
simpleThread.start();
...
pass.get(); //of course, this could return false simply because the newly spawned thread has not completed execution yet