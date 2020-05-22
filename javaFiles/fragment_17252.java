import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class WindowTest extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame();

    public WindowTest() {
        frame.setTitle("Window Test");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.ICONIFIED);
        Timer t = new Timer(3000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                java.awt.EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        frame.setExtendedState(JFrame.NORMAL);
                    }
                });
            }
        });
        t.setRepeats(false);
        t.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                final WindowTest wt = new WindowTest();
            }
        });
    }
}