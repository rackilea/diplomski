import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoggingUtilTest {
    private LoggingUtil loggingUtil;

    private MockHttpServletRequest request = new MockHttpServletRequest();

    @Before
    public void setUpBeforeClass() throws Exception {
        request.setRequestURI("/foo");
        request.setRemoteAddr("10.1.1.11");
        request.addHeader("Authorization", "xAuth");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        loggingUtil = new LoggingUtil();
    }

    @Test
    public final void testLoggingUtil() {
        String requestURI = ReflectionTestUtils.getField(loggingUtil, "uri").toString();
        assertEquals(requestURI,"/foo");

        String authorization = ReflectionTestUtils.getField(loggingUtil, "authorization").toString();
        assertEquals(authorization,"xAuth");

        String callerIp = ReflectionTestUtils.getField(loggingUtil, "callerIp").toString();
        assertEquals(callerIp,"10.1.1.11");
    }
}