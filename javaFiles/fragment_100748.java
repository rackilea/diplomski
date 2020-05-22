public class AbstractDemo {
        abstract static class A { 
        public abstract void callMe(); 
        public void callMeToo() { }
      } 
      public static class B extends A { 
          public void callMe() { } 
      }
      public static void main(String args[]) {

        B b = new B();
        b.callMe();
        b.callMeToo();

     }
}