import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class CheckExit {

    public static void doSomething() {
        try {
            // do something irritating..
            URI uri = new URI(
                    "http://stackoverflow.com/users/418556/andrew-thompson");
            Desktop.getDesktop().browse(uri);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                JPanel gui = new JPanel(new BorderLayout());
                gui.setPreferredSize(new Dimension(400, 100));
                gui.setBackground(Color.WHITE);

                final JFrame f = new JFrame("Demo");
                f.setLocationByPlatform(true);
                f.add(gui);

                // Tell the frame to 'do nothing'.
                f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                WindowListener listener = new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent we) {
                        int result = JOptionPane.showConfirmDialog(
                                f, "Close the application");
                        if (result==JOptionPane.OK_OPTION) {
                            doSomething();
                            f.setVisible(false);
                            f.dispose();
                        }
                    }
                };
                f.addWindowListener(listener);

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