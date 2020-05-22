import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EndOfLineButtonLayout {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                JPanel gui = new JPanel(new BorderLayout());
                gui.setBorder(new EmptyBorder(2, 3, 2, 3));

                JPanel textPanel = new JPanel(new BorderLayout(5,5));
                textPanel.add(new JScrollPane(new JTextArea("Top Text",3,20)), 
                        BorderLayout.PAGE_START);
                textPanel.add(new JScrollPane(new JTextArea("Main Text",10,10)));
                gui.add(textPanel, BorderLayout.CENTER);

                JPanel buttonCenter = new JPanel(new GridBagLayout());
                buttonCenter.setBorder(new EmptyBorder(5,5,5,5));
                JPanel buttonPanel = new JPanel(new GridLayout(0,1,5,5));
                for (int ii=1; ii<6; ii++) {
                    buttonPanel.add(new JButton("Button " + ii));
                }
                // a component added to a GBL with no constraint will be centered
                buttonCenter.add(buttonPanel);

                gui.add(buttonCenter, BorderLayout.LINE_END);

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