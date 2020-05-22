import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @see https://stackoverflow.com/questions/5838842
 * @see https://stackoverflow.com/questions/5864490
 */
public class AlphaTest {

    private static void display() {
        JFrame f = new JFrame("AlphaTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("image.jpg");
        final AlphaPanel ip = new AlphaPanel(icon, 0.75);
        final JSlider slider = new JSlider();
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                int v = slider.getValue();
                ip.setAlpha((float) v / slider.getMaximum());
                ip.repaint();
            }
        });
        f.add(ip, BorderLayout.CENTER);
        f.add(slider, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                display();
            }
        });
    }
}

class AlphaPanel extends JPanel {

    private BufferedImage bi;
    private float[] scales = {1f, 1f, 1f, 0.5f};
    private float[] offsets = new float[4];
    private RescaleOp rop;

    public AlphaPanel(ImageIcon icon, double scale) {

        int width = (int) (scale * icon.getIconWidth());
        int height = (int) (scale * icon.getIconHeight());
        this.setPreferredSize(new Dimension(width, height));
        this.bi = new BufferedImage(
            width, height, BufferedImage.TYPE_INT_ARGB);
        this.bi.createGraphics().drawImage(
            icon.getImage(), 0, 0, width, height, null);
        rop = new RescaleOp(scales, offsets, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bi, rop, 0, 0);
    }

    public void setAlpha(float alpha) {
        this.scales[3] = alpha;
        this.rop = new RescaleOp(scales, offsets, null);
    }
}