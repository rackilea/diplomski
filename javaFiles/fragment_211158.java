import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

/**
 * Holding left-click draws, and
 * right-clicking cycles the color.
 */
class PaintAnyTime {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaintAnyTime();
            }
        });
    }

    Color[]    colors = {Color.red, Color.blue, Color.black};
    int  currentColor = 0;
    BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
    Graphics2D  imgG2 = img.createGraphics();

    JFrame frame = new JFrame("Paint Any Time");
    JLabel label = new JLabel(new ImageIcon(img));

    MouseAdapter drawer = new MouseAdapter() {
        boolean rButtonDown;
        Point prev;

        @Override
        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                prev = e.getPoint();
            }
            if (SwingUtilities.isRightMouseButton(e) && !rButtonDown) {
                // (This just behaves a little better
                // than using the mouseClicked event.)
                rButtonDown  = true;
                currentColor = (currentColor + 1) % colors.length;
                label.repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (prev != null) {
                Point  next = e.getPoint();
                Color color = colors[currentColor];
                // We can safely paint to the
                // image any time we want to.
                imgG2.setColor(color);
                imgG2.drawLine(prev.x, prev.y, next.x, next.y);
                // We just need to repaint the
                // label to make sure the
                // changes are visible
                // immediately.
                label.repaint();
                prev = next;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                prev = null;
            }
            if (SwingUtilities.isRightMouseButton(e)) {
                rButtonDown = false;
            }
        }
    };

    PaintAnyTime() {
        // RenderingHints let you specify
        // options such as antialiasing.
        imgG2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        imgG2.setStroke(new BasicStroke(3));
        //
        label.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        label.setBackground(Color.white);
        label.setOpaque(true);
        label.addMouseListener(drawer);
        label.addMouseMotionListener(drawer);
        Cursor cursor =
            Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
        label.setCursor(cursor);
        frame.add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}