import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddToCustomContentPane {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                JPanel gui = new JPanel(new FlowLayout());
                gui.setBorder(new EmptyBorder(2, 3, 2, 3));
                gui.setBackground(Color.RED);

                JFrame f = new JFrame("Demo");
                f.setContentPane(gui);

                // Acid test.  Can we add buttons direct to the frame?
                f.add(new JButton("Button 1"));
                f.add(new JButton("Button 2"));

                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
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