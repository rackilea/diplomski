import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class CirclePanel extends JPanel implements ActionListener {

    Timer tm = new Timer(15, this);

    boolean grow = true;

    int XDiameter = 20;
    int YDiameter = 20;

    public CirclePanel() {
        tm.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(50, 50, XDiameter, YDiameter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SuperSizeCircle();
        repaint();

    }

    public void SuperSizeCircle() {

        if (XDiameter >= 200) {
            grow = false;
        }
        if (XDiameter <= 20) {
            grow = true;
        }

        if (grow) {
            XDiameter += 3;
            YDiameter += 3;
        } else {
            XDiameter -= 3;
            YDiameter -= 3;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Circle enlarger");
                CirclePanel co = new CirclePanel();
                frame.add(co);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 300);
                frame.setVisible(true);
            }
        });
    }
}