import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawingStuff extends JPanel {
    private static final int PREF_W = 1000;
    private static final int PREF_H = 650;
    private static final Color BG = Color.BLACK;
    private static final Color GRAPHICS_COLOR = Color.RED;
    private static final int LOOP_COUNT = 5000000; // 5 million

    private BufferedImage image = null;
    private MathParams[] params;

    public DrawingStuff(MathParams[] params) {
        this.params = params;
        setBackground(BG);
        image = drawImage();
    }

    private BufferedImage drawImage() {
        BufferedImage img = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();

        g2.setColor(GRAPHICS_COLOR);
        int xLast, yLast;
        for (int i = 0; i < LOOP_COUNT; i++) {
            double dX = params[0].doCalc0(i) + params[1].doCalc1(i);
            double dY = params[2].doCalc0(i) + params[3].doCalc1(i);
            int drawX = (int) dX;
            int drawY = (int) dY;
            if (i == 0) {
                xLast = 0;
                yLast = 0;
                g2.drawLine(xLast, yLast, drawX, drawY);
            } else {
                xLast = drawX;
                yLast = drawY;
                g2.drawLine(xLast, yLast, drawX, drawY);
            }
        }

        g2.dispose();
        return img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Drawing Stuff");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO: fix this -- what numbers to use??? These don't work
        MathParams[] paramArray = { 
                new MathParams(1, 2, 3), 
                new MathParams(1, 2, 3), 
                new MathParams(3, 4, 5),
                new MathParams(3, 4, 5)
                };

        frame.getContentPane().add(new DrawingStuff(paramArray));
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}