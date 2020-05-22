import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ResizeIcon extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;
    private static final int MAX_ICON_WIDTH = 400;
    private int iconWidth = MAX_ICON_WIDTH / 2;
    private CarIcon carIcon = new CarIcon(iconWidth);
    private JLabel carLabel = new JLabel(carIcon);
    private JSlider slider = new JSlider(0, MAX_ICON_WIDTH, iconWidth);

    public ResizeIcon() {
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setSnapToTicks(true);        
        slider.addChangeListener(new SliderListener());

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());
        add(slider, BorderLayout.PAGE_START);
        add(carLabel, BorderLayout.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class SliderListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int value = slider.getValue();
            carIcon.setWidth(value);
            carLabel.repaint();
        }
    }

    private static void createAndShowGui() {
        ResizeIcon mainPanel = new ResizeIcon();

        JFrame frame = new JFrame("Resize Icon");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class CarIcon implements Icon {
    public CarIcon(int aWidth) {
        width = aWidth;
    }

    public void setWidth(int aWidth) {
        this.width = aWidth;
    }

    public int getIconWidth() {
        return width;
    }

    public int getIconHeight() {
        return width / 2;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / 6, width - 1, width / 6);
        Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width / 6, y + width / 3, width / 6,
                width / 6);
        Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3,
                width / 6, width / 6);

        // The bottom of the front windshield
        Point2D.Double r1 = new Point2D.Double(x + width / 6, y + width / 6);
        // The front of the roof
        Point2D.Double r2 = new Point2D.Double(x + width / 3, y);
        // The rear of the roof
        Point2D.Double r3 = new Point2D.Double(x + width * 2 / 3, y);
        // The bottom of the rear windshield
        Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);

        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

        g2.fill(frontTire);
        g2.fill(rearTire);
        g2.setColor(Color.red);
        g2.fill(body);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
    }

    private int width;
}