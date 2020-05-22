import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ SampleClass.class })
public class SampleClassTest {


    @Test
    public void testMethodA() {

        PowerMockito.spy(SampleClass.class);
        PowerMockito.doNothing().when(SampleClass.class);
        SampleClass.executeExit();

        SampleClass.methodA();

        PowerMockito.verifyStatic();
        SampleClass.executeExit();

    }
}