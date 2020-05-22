import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ColoredOvals2 extends JPanel {
    public static final int CELL_WIDTH = 50;
    public static final int SIDE = 8;
    private static final Color BG = Color.WHITE;
    private static final Color DISK_COLOR = Color.BLUE;
    private int centerX = 0;
    private int centerY = 0;

    public ColoredOvals2() {
        setBackground(BG);
        MouseAdapter myMouse = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                moveDisk(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                moveDisk(e);
            }

            private void moveDisk(MouseEvent e) {
                centerX = e.getX();
                centerY = e.getY();
                repaint();
            }
        };
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        int w = SIDE * CELL_WIDTH;
        int h = w;
        return new Dimension(w, h);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(DISK_COLOR);
        int x = centerX - CELL_WIDTH / 2;
        int y = centerY - CELL_WIDTH / 2;
        int w = CELL_WIDTH;
        int h = CELL_WIDTH;
        g2.fillOval(x, y, w, h);
    }

    private static void createAndShowGui() {
        ColoredOvals2 mainPanel = new ColoredOvals2();

        JFrame frame = new JFrame("ColoredOvals2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}