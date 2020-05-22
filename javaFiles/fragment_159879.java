import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SingleColumnFrame {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                // the values of '20' are for gaps between components
                JPanel gui = new JPanel(new GridLayout(0,1,20,20));
                // adjust numbers as required
                gui.setBorder(new EmptyBorder(40, 200, 40, 200));

                gui.add(new JLabel("FPS: ERROR",SwingConstants.CENTER));
                gui.add(new JLabel("FPS done: ERROR",SwingConstants.CENTER));

                JFrame f = new JFrame("Demo");
                f.add(gui);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                f.setResizable(false);
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}