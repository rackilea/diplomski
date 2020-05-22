import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.*;

import static org.junit.Assert.*;
@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class TestClass {

    @Test
    public void yourTest()
    {
        ServiceRegistrator serTestObj = new ServiceRegistrator();

        PowerMock.mockStatic(IdGenerator.class);
        expect(IdGenerator.generateNewId()).andReturn(42L);
        PowerMock.replay(IdGenerator.class);
        long actualId = IdGenerator.generateNewId();

        PowerMock.verify(IdGenerator.class);
        assertEquals(42L,actualId);
     }

    @Test
    public void unaffectedTest() {
        long actualId = IdGenerator.generateNewId();

        PowerMock.verify(IdGenerator.class);
        assertEquals(3L,actualId);
    }
}