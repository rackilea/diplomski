class Test {
    public void hello() {
        System.out.println("Hello");
    }
}
abstract class AbstractTest extends Test {
    public abstract void hello();
}
class ConcreteTest extends AbstractTest {   
}