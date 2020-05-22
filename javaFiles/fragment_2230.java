import static org.junit.Assert.assertSame;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Example.class)
public class ExampleTest {
    @Test
    public void should_invoke_overloaded_method() throws Exception {
        final String str = "someString";
        Param paramMock = mock(Param.class);
        Example expectedMock = mock(Example.class);

        mockStatic(Example.class);

        when(Example.method(str, paramMock)).thenCallRealMethod();
        when(Example.class, "method", str, paramMock, null).thenReturn(expectedMock);

        assertSame(expectedMock, Example.method(str, paramMock));
    }
}