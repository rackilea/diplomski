import javax.swing.*;
import java.awt.*;

public class RecursiveCirclesPanel extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int radius = (int) (Math.min(getWidth(), getHeight()) * 0.9 / 2);
        int centerx = getWidth() / 2;
        int centery = getHeight() / 2;

        displayOvals(g, radius, centerx, centery);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    private void displayOvals(Graphics g, int radius, int centerx, int centery) {
        if (radius >= 5) {
            g.drawOval(centerx - radius, centery - radius, 2 * radius, 2 * radius);

            displayOvals(g, radius - 5, centerx, centery);
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, new RecursiveCirclesPanel());
    }
}