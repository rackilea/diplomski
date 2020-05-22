public class MyClass {
    private int test;

    public void example() {
         // this refers to MyClass here (the current scope)
         this.test = 0;
         OnClickListener listener = new View.OnClickListener() {
              // Now we are in the intalization of a new Object.
              // "this" refers to the OnClickListener that you are creating
         }
    }
}