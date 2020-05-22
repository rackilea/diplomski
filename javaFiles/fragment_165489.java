import junit.framework.TestCase;
public class Test extends TestCase {

    public void testSomething() {

        assertTrue(new Check().check());
    }   
}
abstract class AbstractCheck {

    protected abstract boolean check();
}
class Check extends AbstractCheck {

    @Override
    protected boolean check() {
        return true;
    }
}