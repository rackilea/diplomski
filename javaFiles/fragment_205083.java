import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class SampleClassTest {

    @Rule
    ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testMethodA() {

        exit.expectSystemExitWithStatus(-1);
        SampleClass.methodA();
    }
}