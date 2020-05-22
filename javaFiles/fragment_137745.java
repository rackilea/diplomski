import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(A.class)
public class BTest{

    @Test
    public void thatCallingClassMakesExpectedCalls() {
        final A mockA = PowerMock.createMock(A.class);
        EasyMock.expect(mockA.doStuff()).andReturn("lol").anyTimes();

        PowerMock.mockStatic(A.class);
        EasyMock.expect(A.getInstance()).andReturn(mockA).anyTimes();

        PowerMock.replayAll(mockA);

        final B callingClass = new B();
        final String doBdo = callingClass.doBdo();
        assertThat(doBdo, is("lol"));

        EasyMock.verify(mockA);
        PowerMock.verifyAll();
    }
}