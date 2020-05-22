public final class Child extends Parent {

   private final String someText; // final is not necessary there, but it is a good practice, to declare fields like this as final. Because it gets its value once, and does not change later.

   public Child(String someText) {
     super(); // calling parent's constructor
     this.someText = someText;
   }

   public String getSomeText() {
     return this.someText;
   }    
}