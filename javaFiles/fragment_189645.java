public class DesktopLauncher {
    static {
        java.awt.Toolkit.getDefaultToolkit();
    }

    public static void main(final String[] arg) {
        final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new Game(), config);
    }
}