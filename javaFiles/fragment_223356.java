public class MyClass {
     public static class StringGetter {
         public getString() {
             return OtherClass.getString();                 
         }
     }

     private final StringGetter getter;

     //Existing Constructor
     public MyClass() {
         this(new StringGetter());
     }

     //DI Constructor
     MyClass(StringGetter getter) {
         this.getter = getter;
     }

     public void doGetString() {
         ...
         getter.getString();
         ...
     }
}