import java.awt.*;
import javax.swing.*;

public class DrawTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("DrawTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new DrawComponent());
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
    }
}

class DrawComponent extends JComponent {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(320, 240);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        String msg = getWidth() + " x " + getHeight();
        g2.setPaint(Color.BLUE);
        int w = (getWidth() - g.getFontMetrics().stringWidth(msg)) / 2;
        g2.drawString(msg, w, getHeight() / 2);
    }
}