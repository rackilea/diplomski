import javafx.embed.swing.JFXPanel;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SomeClass {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Swing Frame");
                JFXPanel jfxp = new JFXPanel();
                frame.getContentPane().add(jfxp);
                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                NetworkUI.main();
            }
        });
    }
}