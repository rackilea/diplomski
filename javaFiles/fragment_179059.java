import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Boom.class})
public class DocTest {

    public String boomWrapper() {
        return Boom.detonate();
    }

    @Test
    public void testBoom() {
        mockStatic(Boom.class);
        when(Boom.detonate()).thenReturn("defused");
        String actual = boomWrapper();
        verifyStatic(Boom.class, times(1));
        Boom.detonate();
        assertEquals("defused", actual);
    }    
}

class Boom {
    private static final String BOOM = "Boom!";  
    public static String detonate() {
        return BOOM;
    }
}