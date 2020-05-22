public abstract class Base {
     public final sayHello() {
         System.out.println("Hello world");
     }

     public abstract void someMethod();

     public static Base nonNullVersion() {
         return new NonNullBase();
     }

     public static Base nullVersion() {
         return new NullBase();
     }

     private static final class NonNullBase extends Base {
        @Override
        public void someMethod() {
            // this stuff does the non-null behaviour
        }
     }

     private static final class NullBase extends Base {
        @Override
        public void someMethod() {
            // this stuff does the null behaviour
        }
     }
}