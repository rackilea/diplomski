import static org.junit.Assert.*;
import net.sf.cglib.proxy.Mixin;

import org.junit.Before;
import org.junit.Test;


public class MixinTest {

    @Test
    public void test() {
        Mixin mixin = Mixin.create(new Object[]{ new Class1(), new Class2() });
        assertEquals(1, ((Interface1)mixin).method1());
        assertEquals(2, ((Interface2)mixin).method2());
    }

    private interface Interface1 {
        public int method1();
    }

    private interface Interface2 {
        public int method2();
    }

    private static class Class1 implements Interface1 {

        @Override
        public int method1() {
            return 1;
        }

    }

    private static class Class2 implements Interface2 {

        @Override
        public int method2() {
            return 2;
        }

    }

}