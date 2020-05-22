import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SomeTest {
    @Test
    public void testSomething() {
        Object o1 = new Object();
        Object o2 = o1;

        assertThat(o1, sameInstance(o2));
    }
}