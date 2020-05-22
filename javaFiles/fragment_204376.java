import java.awt.*;
import javax.swing.*;

public class CustomPaint {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame("CustomPaint");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MyPanel());
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
    }
}

class MyPanel extends JPanel {

    public Dimension getPreferredSize() {
        return new Dimension(320, 240);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        String msg = "HELLO JAVA";
        g2.setPaint(Color.BLUE);
        int w = (getWidth() - g.getFontMetrics().stringWidth(msg)) / 2;
        g2.drawString(msg, w, getHeight() / 2);
    }
}