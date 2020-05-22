import java.util.prefs.Preferences;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingPreferencesTest {

    private void createAndShowGUI() {

        JTextField dummyTextField = new JTextField(20);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(dummyTextField);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        Preferences prefs = Preferences.userRoot().node(this.getClass().getName());

        // Define default values here
        System.out.println("width: " + prefs.getDouble("width", 100d));
        System.out.println("height: " + prefs.getDouble("height", 100d));
        System.out.println("x: " + prefs.getDouble("x", 0d));
        System.out.println("y: " + prefs.getDouble("y", 0d));

        // Set new values here
        prefs.putDouble("width", frame.getPreferredSize().getWidth());
        prefs.putDouble("height", frame.getPreferredSize().getHeight());
        prefs.putDouble("x", frame.getLocationOnScreen().getX());
        prefs.putDouble("y", frame.getLocationOnScreen().getY());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingPreferencesTest().createAndShowGUI();
            }
        });
    }
}