public class C extends A {

  public void travel() {
     super.travel();
     System.out.println("Travel from C");
  }

   public void makePee(){
      throw new UnsupportedOperationException("Not supported from C");
   }
}