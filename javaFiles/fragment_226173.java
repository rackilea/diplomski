import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test2 {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test2()::display);
    }

    public void display() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final MyDrawPanel drawPanel = new MyDrawPanel();
        frame.add(drawPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class MyDrawPanel extends JPanel {

        private int x = 30;
        private int y = 30;
        private final List<Shape> list = new ArrayList<>();

        public MyDrawPanel() {
            new Timer(50, (new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    x++;
                    y++;
                    list.add(new Ellipse2D.Double(x, y, 40, 40));
                    repaint();
                }
            })).start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(Color.green);
            for (Shape s : list) {
                g2d.fill(s);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }
    }
}