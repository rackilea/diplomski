public class FXLauncher {
    public static void main(String[] args) {
        FXApplication application = new FXApplication();
        application.handleArgs(args);
        new Thread(application ).start();
    }
}