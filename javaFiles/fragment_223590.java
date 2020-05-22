import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class Test101 extends JPanel {

    double scale = 0;
    String draw = "1";

    Test101() {
        setPreferredSize(new Dimension(600, 600));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        paintText(g2, 0, 0);

        int x = getWidth() / 2;
        int y = getHeight() / 2;
        g2.setColor(Color.RED);
        g2.drawLine(x, 0, x, getHeight());
        g2.drawLine(0, y, getWidth(), y);
    }

    public void paintText(Graphics2D g, int x, int y) {

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        FontMetrics fm = g.getFontMetrics();
        System.out.println(fm.getAscent());
        scale = getHeight() / (fm.getHeight());

        Font font = g.getFont().deriveFont(Font.PLAIN, AffineTransform.getScaleInstance(scale, scale));
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        fm = g.getFontMetrics(font);
        int xPos = (getWidth() - fm.stringWidth(draw)) / 2;
        int yPos = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2d.drawString(draw, xPos, yPos);
        g2d.dispose();

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("test");
                frame.add(new Test101());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}