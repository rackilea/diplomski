public class Base {
   public static final Base NULL = new Base() {
        @Override
        public void someMethod() {
           // this guy does the null version.
        }
    }

    public void someMethod() {
        // this stuff does the non-null behaviour
    } 
}