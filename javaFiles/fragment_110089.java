public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {

            // Use Nimbus if it's available and we're not on Mac OSX
            if (!System.getProperty("os.name").equals("Mac OS X")) {
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());

                            ((InputMap) UIManager.get("Button.focusInputMap"))
                                    .put(KeyStroke.getKeyStroke("pressed ENTER"), null);
                            ((InputMap) UIManager.get("Button.focusInputMap"))
                                    .put(KeyStroke.getKeyStroke("released ENTER"), null);

                            break;
                        }
                    }
                } catch (Exception e) {
                    // Default Look and Feel will be used
                }
            }

            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        }
    });
}