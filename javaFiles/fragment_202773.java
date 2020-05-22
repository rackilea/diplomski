import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Paint {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paint");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        Draw draw = new Draw();
        frame.add(draw);
        frame.setVisible(true);
    }

    public static class Draw extends JPanel {

        public Draw() {
            JLabel one = new JLabel("12", JLabel.CENTER);
            setLayout(new FlowLayout());
            add(one);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            g.drawOval(70, 60, 190, 190);

            g.setColor(Color.BLACK);
            g.drawLine(90, 160, 170, 160);
            g.drawLine(120, 190, 170, 160);

            g.setColor(Color.GRAY);
            g.fillOval(155, 153, 20, 20);
        }
    }
}