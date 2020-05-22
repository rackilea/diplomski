import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.Timer;

class WindowScanner extends JFrame {
    private JLabel label;
    private JToggleButton captureButton = new JToggleButton("CAPTURE");

    WindowScanner() {
        super("Fist Window");
        setSize(150, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        add(captureButton);
        setVisible(true);

        new Scanner(this);
    }

    public JToggleButton getCaptureButton() {
        return captureButton;
    }
}

class Scanner extends JFrame {
    private WindowScanner wS;
    private int delay = 1000;
    private Timer t = new Timer(delay, new taskPerformer());

    Scanner(WindowScanner wS) {
        super("Second Window");
        this.wS = wS;
        setBounds(200,0,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        wS.getCaptureButton().addActionListener(new taskPerformer());
    }

    private Color randomColor() {
        Random rand = new Random();
        float r = rand.nextFloat() / 2f ;
        float g = rand.nextFloat() / 2f;
        float b = rand.nextFloat() / 2f;
        Color randomColor = new Color(r, g, b);
        return randomColor;
    }

    private class taskPerformer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent captureEvent) {
            if(captureEvent.getSource() == wS.getCaptureButton()) {
                if (wS.getCaptureButton().isSelected()) {
                    t.start();
                } else {
                    t.stop();
                }
            }

            if(captureEvent.getSource() == t) {
                getContentPane().setBackground(randomColor());
                revalidate();
                repaint();
            }
        }
    }
}

public class Main {
    public static void main (String[] args) {
        new WindowScanner();
    }
}