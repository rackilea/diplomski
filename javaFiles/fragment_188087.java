final GlobalVariables global = new GlobalVariables();
Thread thread1 = new Thread(){
  public void run(){
    DeliverMessage deliverMess = new DeliverMessage();
    deliverMess.setGlobalVariables(global);
    deliverMess.deliver();
  }
}

Thread thread2 = new Thread(){
  public void run(){
    Timing time = new Timing();
    time.setGlobalVariables(global);
    time.controlTime();
  }
}
thread1.start();
thread2.start();