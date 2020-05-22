public class TestClass extends JFrame {

    public void ExitApp() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Dispose Java (TM) Platform SE binary.
                dispose();
                // Close the Java.exe I'm not sure.
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        // Close Your Application Trigger ExitApp();
        System.exit(0);
    }
}