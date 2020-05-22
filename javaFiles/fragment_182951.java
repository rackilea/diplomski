public class Startup {

    private static final boolean TEST_MODE = false;

    public static void main(String[] args) {
        if (TEST_MODE) {
            TestSuite testSuite = new TestSuite();
            testSuite.execute();
        } else {
            Main main = new Main();
            main.execute();
        }
    }
}