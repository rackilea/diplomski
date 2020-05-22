import java.awt.*;
import java.awt.image.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

class TextSize {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Technique 1 - FontMetrics
                String s = "The quick brown fox jumps over the lazy dog!";
                BufferedImage bi = new BufferedImage(
                    1,
                    1,
                    BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                FontMetrics fm = g.getFontMetrics();
                Rectangle2D b = fm.getStringBounds(s,g);
                System.out.println(b);
                bi = new BufferedImage(
                    (int)b.getWidth(),
                    (int)(b.getHeight() + fm.getDescent()),
                    BufferedImage.TYPE_INT_RGB);
                g = bi.getGraphics();
                g.drawString(s,0,(int)b.getHeight());

                JOptionPane.showMessageDialog(
                    null,
                    new JLabel(new ImageIcon(bi)));

                // Technique 3 - JLabel
                JLabel l = new JLabel(s);
                l.setSize(l.getPreferredSize());
                bi = new BufferedImage(
                    l.getWidth(),
                    l.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
                g = bi.getGraphics();
                g.setColor(Color.WHITE);
                g.fillRect(0,0,400,100);
                l.paint(g);

                JOptionPane.showMessageDialog(
                    null,
                    new JLabel(new ImageIcon(bi)));
            }
        });
    }
}