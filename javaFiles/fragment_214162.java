import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author David
 */
public class JSpinnerMouse extends JFrame {

    private JSpinner jspinner;

    public JSpinnerMouse() {
        createAndShowUI();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JSpinnerMouse jSpinnerMouse = new JSpinnerMouse();
            }
        });
    }

    private void createAndShowUI() {
        setTitle("JSpinner using mouse wheel");
        setSize(300, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addComponentsToContentPane(getContentPane());
        addListeners();
        setVisible(true);
    }

    private void addComponentsToContentPane(Container contentPane) {
        jspinner = new JSpinner();
        contentPane.add(jspinner);
    }

    private void addListeners() {
        this.addMouseWheelListener(new MouseWheelListener() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent mwe) {
                if (MouseWheelEvent.WHEEL_UNIT_SCROLL == mwe.getScrollType()) {
                    int value = (int) jspinner.getValue();
                    if (mwe.getWheelRotation() == -1) {//up
                        jspinner.setValue(value + 1);
                    } else {//down
                        jspinner.setValue(value - 1);
                    }
                }
            }
        });
    }
}