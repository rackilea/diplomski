public class TestInvisibleObject{
  public static class PrintWhenFinalized{
    private String s;
    public PrintWhenFinalized(String s){
      System.out.println("Constructing from "+s);
      this.s = s;
    }
    protected void finalize() throws Throwable {
      System.out.println("Finalizing from "+s);
    }   
  }
  public static void main(String[] args) {
    try {
        PrintWhenFinalized foo = new PrintWhenFinalized("main");
    } catch (Exception e) {
        // whatever
    }
    while (true) {
      // Provoke garbage-collection by allocating lots of memory
      byte[] o = new byte[1024];
    } 
  }
}