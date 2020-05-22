public class InitScreen {

    public void createHomeScreen() {
        //...
    }

    public static void main(final String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                InitScreen screen = new InitScreen();
                screen.createHomeScreen();
            }
        });
    }