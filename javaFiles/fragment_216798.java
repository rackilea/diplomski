import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ SmallCalculator.class})
public class BigTester {

    @Test
    public void bigTest(){

        PowerMockito.mockStatic(SmallCalculator.class);
        PowerMockito.when(SmallCalculator.getLength(any(String.class))).thenReturn(5);

        BigCalculator bigCalculator = new BigCalculator();
        assertEquals(5, bigCalculator.getLength());
    }
}