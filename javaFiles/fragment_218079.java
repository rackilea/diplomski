import java.awt.event.*;
import javax.swing.*;

public class WindowClosing {
    private static final int DELAY = 3000;

    public WindowClosing() {
        Timer timer = new Timer(DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                ;
            }
        });
        timer.setRepeats(false);
        JFrame frame = createFrame(timer);
        frame.setVisible(true);

    }

    private JFrame createFrame(final Timer timer) {
        final JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                timer.start();
                JOptionPane.showMessageDialog(frame, "WindowClosing");
            }
        });
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WindowClosing();
            }
        });
    }
}