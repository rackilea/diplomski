import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Test {

    private boolean firstTime2 = true;
    private boolean firstTime = true;
    private JFrame frame;
    private JLabel focusLabel=new JLabel("");

    public Test() {
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }

    private void initComponents() {
        initFrame();
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                super.mouseMoved(me);
                firstTime2 = false;
                firstTime = false;
                if (frame.isUndecorated()) {
                    focusLabel.setText("Focused");
                    firstTime = true;
                    firstTime2 = true;
                    frame.dispose();
                    frame.setUndecorated(false);
                    showFrame();
                }
            }
        });

        frame.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                if (firstTime) {
                    focusLabel.setText("Focused");
                    firstTime = false;
                    frame.dispose();
                    frame.setUndecorated(false);
                    showFrame();
                }
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                if (!firstTime2) {
                    focusLabel.setText("Not focused");
                    frame.dispose();
                    frame.setUndecorated(true);
                    showFrame();
                }
                firstTime2 = false;
            }
        });

        showFrame();
    }

    private void initFrame() {
        frame = new JFrame() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(focusLabel);
    }

    private void showFrame() {
        frame.pack();
        frame.setVisible(true);
    }
}