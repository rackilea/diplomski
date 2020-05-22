public class TestConsoleHandler {

    private static Thread hook;

    public static void main(String[] args) {
        System.out.println("Start");
        hook = new ShutdownHook();
        Runtime.getRuntime().addShutdownHook(hook);
        replaceConsoleHandler(); // actually not "replace" but "add"

        try {
            Thread.sleep(10000); // You have 10 seconds to close console
        } catch (InterruptedException e) {}
    }

    public static void shutdown() {
        hook.run();
    }

    private static native void replaceConsoleHandler();

    static {
        System.loadLibrary("TestConsoleHandler");
    }
}

class ShutdownHook extends Thread {
    public void run() {
        try {
            // do some visible work
            new File("d:/shutdown.mark").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Shutdown");
    }
}