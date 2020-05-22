import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"val1=v1", "val2=v2"})
public class SomeTest {

    @Value("#{ '${val1:}' != '' ? '${val1}' : ('${val2:}' != '' ? 'default1' : 'default2')}")
    private String testVal;

    @Value("${nonExistingValue}")
    private String nonExistingValue;

    @Test
    public void test() {
        assertThat(testVal).isEqualTo("v1");
    }

    @Test
    public void testNonExistingValue() {
        assertThat(nonExistingValue).isEqualTo("${nonExistingValue}");
    }
}