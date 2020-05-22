public class SuperClass {
   public SuperClass(String parameter) {
       // this is called when anonymous class is created
   }
}

// an anonymous class is created and instantiated here
new SuperClass(parameterForSuperClassConstructor) {
   {
      // this code is executed when object is initialized
      // and can be used to do many same things as a constructors
   }

   private void someMethod() {

   }

}