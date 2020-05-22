import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private JLabel locationLabel = new JLabel();
    private int mouseX = 0;
    private int mouseY = 0;

    public DrawPanel() {
        add(locationLabel);
        addMouseMotionListener(new MyMouseAdapter());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // this allows JPanel to do housekeeping
                                 // painting first

            // do drawing here!
            g.drawLine(0, mouseY, getWidth(), mouseY);
            g.drawLine(mouseX, 0, mouseX, getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();

            // get Point location and turn into a String
            String location = String.format("[%d, %d]", mouseX, mouseY);

            // set the label's text with this String
            locationLabel.setText(location);

            repaint();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("DrawPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}