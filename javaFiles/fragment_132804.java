public class SuperClass {
    public int getNb() {
         //specify what must happen
        return 1;
     }

     public int getNb2() {
         //specify what must happen
        return 2;
     }
 }

 public class SubClass extends SuperClass {
      //you can override the implementation
      @Override
      public int getNb2() {
        return 3;
     }
 }