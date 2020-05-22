public class ShutdownHook {
public void attachShutDownHook() {
    Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
            System.out.println("exit");
        }
    });

}

public static void main(String[] args) {
    ShutdownHook sample = new ShutdownHook();
    sample.attachShutDownHook();
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}