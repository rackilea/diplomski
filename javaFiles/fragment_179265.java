import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PaddedTextArea {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                JPanel gui = new JPanel(new BorderLayout());
                // adjust as needed
                gui.setBorder(new EmptyBorder(20,10,20,10));

                // better way to size a text area is using columns/rows 
                // in the constructor
                JTextArea ta = new JTextArea(3,40);
                JScrollPane sp = new JScrollPane(ta);
                gui.add(sp);

                JFrame f = new JFrame("Padded Text Area");
                f.add(gui);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See https://stackoverflow.com/a/7143398/418556 for demo.
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
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}