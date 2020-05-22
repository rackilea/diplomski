public class Foo {
    private int x;

    public Foo() {
      doDefaultInitialize();
    }

    public Foo(int x) {
        try {
          // dodgy code which could throw
        }
        catch(Exception ge){
          doDefaultInitialize();        
        }
    }

    private void doDefaultInitialize() {
       // Fallback initialization goes here
       x = 42;
    }
}