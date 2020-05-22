package example;

import org.junit.jupiter.api.Nested;

class Testing {

    static String[] text() {
        return new String[] { "A", "B" };
    }

    @Nested
    class NestedTesting {

        @ParameterizedTextTest
        void testA(String text) {
            System.out.println(text);
        }

        @ParameterizedTextTest
        void testB(String text) {
            System.out.println(text);
        }
    }
}