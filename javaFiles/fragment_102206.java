public class Test {

    public static void checkServer() {
        if (!checkNetwork()) {
            return;
        }
    }

    public static void checkClient() {
        if (!checkNetwork()) {
            return;
        }
    }

    private static boolean checkNetwork() {
        return true; // or false depending on network condition
    }
}