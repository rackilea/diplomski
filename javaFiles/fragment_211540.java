class Test {

    static final int ONE = 1;
    static final int TWO = 2;

    enum TestEnum {ONE, TWO}

    public static void main(String[] args) {
        testEnum();
        testInteger();
        time("enum", new Runnable() {
            public void run() {
                testEnum();

            }
        });
        time("integer", new Runnable() {
            public void run() {
                testInteger();
            }
        });
    }

    private static void testEnum() {
        TestEnum value = TestEnum.ONE;
        for (int i = 0; i < 1000000000; i++) {
            if (value == TestEnum.TWO) {
                System.err.println("impossible");
            }
        }
    }

    private static void testInteger() {
        int value = ONE;
        for (int i = 0; i < 1000000000; i++) {
            if (value == TWO) {
                System.err.println("impossible");
            }
        }
    }

    private static void time(String name, Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        System.err.println(name + ": " + (System.currentTimeMillis() - startTime) + " ms");
    }
}