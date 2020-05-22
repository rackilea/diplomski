class Test {
    public void hello() {
        System.out.println("Hello");
    }
}

abstract class AbstractTest extends Test {  }

class ConcreteTest extends AbstractTest {
    // Inherits the hello() method from AbstractTest, 
    // which in turn inherits it from Test.
}