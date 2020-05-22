public class Scratch2 {
    // Arguments and accessor for them.

    private static String[] savedArgs;
    public static String[] getArgs() {
        return savedArgs;
    }

    public static void main(String[] args) {
        // Save them away for later.

        savedArgs = args;

        // Test that other classes can get them.

        CmdLineArgs cla = new CmdLineArgs();
        cla.printArgs();
    }
}