import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Factory.class)
public class Tests extends TestCase {

    public void testFactory() throws Exception {

        mockStatic(Factory.class, Mockito.CALLS_REAL_METHODS);
        suppress(method(Factory.class, "checkString", String.class));
        String s = Factory.factorObject();
        verifyPrivate(Factory.class, times(1)).invoke("checkString", anyString()); 
        assertEquals("Hello Mary Lou", s);      
    }
}