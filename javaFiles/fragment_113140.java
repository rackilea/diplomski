import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

@PrepareForTest(AbstractAnimal.class)
public class AbstractAnimalTest extends PowerMockTestCase {

    @Test
    public void shouldGetMockedHello() {
        PowerMockito.mockStatic(AbstractAnimal.class);
        PowerMockito.when(AbstractAnimal.getHello()).thenReturn("Hello mocked animal world!");

        String greetings = AbstractAnimal.getHello();
        Assert.assertTrue(greetings.equals("Hello mocked animal world!"));
    }

}