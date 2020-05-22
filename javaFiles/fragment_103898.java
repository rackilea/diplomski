import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * @author maba, 2012-09-13
 */
public class InstanceOfTest {

    @Test
    public void testInstanceOf() {
        SubClass subClass = new SubClass();
        assertThat(subClass, instanceOf(BaseClass.class));
    }
}