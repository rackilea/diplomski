import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CollectionUtil.class)
public class TestHarnesTest {
    @InjectMocks
    TestHarnes w_res = new TestHarnes();

    @Before
    public void before() {
        PowerMockito.mockStatic(CollectionUtil.class);
    }

    @Test
    public void test_removeHashedSettings() throws Exception {
        HashMap<String, String> w_abc = new HashMap<String, String>();
        w_abc.put("abc", "89");
        // CollectionUtil mock = org.mockito.Mockito.mock(CollectionUtil.class);
        // PowerMockito.mockStatic(CollectionUtil.class,w_abc);
        PowerMockito.when(CollectionUtil.createHashMap(Mockito.eq("abc:89"), Mockito.eq(":"))).thenReturn(w_abc);
        assertEquals("abc:89:", TestHarnes.removeHashedSettings("1", "abc:89", ":"));
    }
}