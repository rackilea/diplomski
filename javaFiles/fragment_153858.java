class R implements Runnable {

  private final boolean myBool;

  public R(boolean myBool) {
    this.myBool = myBool;
  }

  public void run(){
    if (myBool) {
      System.out.print("hello");
    } else {
      System.out.print("goodbye");
    }
  }
}