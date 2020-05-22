import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public final class Borders extends JFrame {

    public Borders() {
        JTextField field = new JTextField();
        Border outsideBorder = field.getBorder();
        field.setBorder(new CompoundBorder(outsideBorder, new AbstractBorder() {

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Insets insets = outsideBorder.getBorderInsets(c);
                Font font = c.getFont();
                FontMetrics metrics = c.getFontMetrics(font);
                int by = (c.getHeight() / 2) + (metrics.getAscent() / 2) - insets.top;
                int bw = Math.max(2, insets.left); // border width
                int iw = metrics.stringWidth("=="); // icon width
                int bx = x + width - (Math.round(iw * 1.5f) + (bw * 2)) + 2;
                g.translate(bx, by);
                g.setColor(Color.RED);
                g.setFont(c.getFont().deriveFont(Font.BOLD, font.getSize()));
                g.drawString("==", x + (iw / 2), y);
            }

            @Override
            public boolean isBorderOpaque() {
                return true;
            }

            @Override
            public Insets getBorderInsets(Component c, Insets insets) {
                insets.right = 15;
                return insets;
            }
        }));
        this.add(field);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Borders().setVisible(true);
        });
    }

}