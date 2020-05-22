class SharedResource {
  public static void staticMethod(){
    synchronized(SharedResource.class) {
      System.out.println("static Method is called");
      y++;
    }
  }
  public void incrementX(){
    synchronized(this) {
      System.out.println("instance method; incrementX");
      x++;
    }
  }
}