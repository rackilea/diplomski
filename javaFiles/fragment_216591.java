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

    public DrawPanel() {
        add(locationLabel);
        addMouseMotionListener(new MyMouseAdapter());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // this allows JPanel to do housekeeping painting first

        // do drawing here!

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
            // get Point location and turn into a String
            String location = String.format("[%d, %d]", e.getX(), e.getY());

            // set the label's text with this String
            locationLabel.setText(location);
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