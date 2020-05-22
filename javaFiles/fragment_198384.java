public class ShutdownHookDemo {
    public void start() {
        System.out.println("Demo");
        ShutdownHook shutdownHook = new ShutdownHook();
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }

    public static void main(String[] args) {
        ShutdownHookDemo demo = new ShutdownHookDemo();
        demo.start();
        try {
            System.in.read();
        }
        catch(Exception e) {
        }
    }
}

class ShutdownHook extends Thread {
    public void run() {
        System.out.println("Shutting down");
        //terminate all other stuff for the application before it exits
    }

}