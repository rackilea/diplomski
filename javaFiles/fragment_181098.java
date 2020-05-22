public void start () {
  System.out.println("Starting " +  threadName);
  if (t == null) {
    t = new Thread (this, threadName);
    t.start ();
  }
}