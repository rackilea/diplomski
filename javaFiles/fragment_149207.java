import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.eq;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Foo.class)
public class SimpleTest {

    @Test
    public void testHello() throws Exception {
        Foo foo = PowerMockito.spy(new Foo());
        foo.sayHello();
        PowerMockito.verifyPrivate(foo).invoke("hello", eq("User"));
    }
}

class Foo {
    public void sayHello() {
        System.out.println(hello("User"));
    }

    private String hello(String user) {
        return "Hello " + user;
    }
}