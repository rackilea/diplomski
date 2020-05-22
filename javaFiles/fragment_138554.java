public class ClassB {
   private ClassA a;

   // pass the ClassA reference into the ClassB constructor
   public ClassB(ClassA a) {
     this.a = a;   // assign it to the a field
     // a.showText();  // or you can do this if you need it called in the constructor
   }

   // or do this if you want the a method called in a ClassB method.
   public void callAShowText() {
     a.showText();
   }
}