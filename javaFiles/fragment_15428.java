import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TransparentDrawTest extends JPanel implements MouseListener {

    private final static Dimension SIZE = new Dimension(400, 50);

    private boolean isSelected;
    private boolean isClicked;

    public static void main(String[] args) {

        JFrame testFrame = new JFrame();
        testFrame.setSize(500, 100);
        testFrame.setResizable(false);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setLocationRelativeTo(null);
        testFrame.setBackground(Color.WHITE);

        JPanel semiTransPanel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); 
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(getBackground());
                g2d.setComposite(AlphaComposite.SrcOver.derive(0.6f));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }

        };
        semiTransPanel.setOpaque(false);
        semiTransPanel.setBackground(Color.RED);
        semiTransPanel.add(new TransparentDrawTest());

        testFrame.add(semiTransPanel);
        testFrame.setVisible(true);
    }

    public TransparentDrawTest() {

        this.addMouseListener(this);

        this.setSize(SIZE);
        this.setMinimumSize(SIZE);
        this.setMaximumSize(SIZE);
        this.setPreferredSize(SIZE);

        this.setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int[] pointsX;
        int[] pointsY;

        if (this.isSelected) {
            pointsX = new int[]{2, 348, 398, 48};
            pointsY = new int[]{2, 2, 48, 48};
        } else {
            pointsX = new int[]{2, 298, 348, 48};
            pointsY = new int[]{2, 2, 48, 48};
        }

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.WHITE);
        Composite comp = g2d.getComposite();

        if (this.isClicked) {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
        } else {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }

        g2d.fillPolygon(pointsX, pointsY, 4);
        g2d.setComposite(comp);
        g2d.drawPolygon(pointsX, pointsY, 4);
        g2d.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.isSelected = true;
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.isSelected = false;
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.isClicked = true;
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.isClicked = false;
        this.repaint();
    }
}