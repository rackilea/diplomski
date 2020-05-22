import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NewTest extends JPanel implements ActionListener, Runnable {

    private Random r = new Random();
    private Timer t = new Timer(10, this);

    public static void main(String[] args) {
        EventQueue.invokeLater(new NewTest());
    }

    @Override
    public void run() {
        JFrame f = new JFrame("NewTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        t.start();
    }

    public NewTest() {
        super(true);
        this.setPreferredSize(new Dimension(640, 480));
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.RED);
        g.drawLine(r.nextInt(width), r.nextInt(height),
            r.nextInt(width), r.nextInt(height));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }
}