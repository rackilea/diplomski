package foo.bar.test;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MyRunner.class)
public class TestCase {

    @Test
    public void myTest() {
        System.out.println("executed");
    }

}