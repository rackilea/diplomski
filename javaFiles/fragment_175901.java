class SharedResource {
  public synchronized static void staticMethod(){
    System.out.println("static Method is called");
    y++; 
  }
  public synchronized void incrementX(){
     System.out.println("instance method; incrementX");
     x++;
  }
}