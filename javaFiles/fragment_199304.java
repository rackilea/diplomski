public class A {

  public void travel() {
     System.out.println("Travel from A");
  }

  public void makePee() {
     System.out.println("Call from A");
  }

}

public class B extends A {

  public void travel() {
     super.travel();
     System.out.println("Travel from B");
  }

   public void makePee() {
      super.makePee();
      System.out.println("Call from B");
   }

}