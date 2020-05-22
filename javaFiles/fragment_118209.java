// srce/test/java/pkg/SomeTest.java
import org.junit.Test;

public class SomeTest {

    @Test
    public void test() {
        new SomeMock();
        new SomeClass("a", 2);
    }

}