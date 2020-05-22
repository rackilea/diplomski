import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;

@RunWith(MockitoJUnitRunner.class)
public class ATest {

    @Mock
    private B b;

    private A a;

    @Before
    public void prepareTest() {
        doNothing().when(b).doSomething();

        a = new A();
        Whitebox.setInternalState(a, B.class, b);
    }

    @Test
    public void doSomething() {
        a.doSomething();
        verify(b).doSomething();
    }

}