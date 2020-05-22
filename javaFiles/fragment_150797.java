import javax.swing.JToggleButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class Test extends JFrame {
    private JToggleButton captureButton = new JToggleButton("CAPTURE");

    Test() {
        super("Fist Window");
        setSize(150, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        add(captureButton);
        setVisible(true);
    }

    public JToggleButton getCaptureButton() {
        return captureButton;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Test frame = new Test();
            }
        });
    }
}