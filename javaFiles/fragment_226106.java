import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class ExampleGraphics2 extends JPanel {
    private static final int PREF_W = 650;
    private static final int PREF_H = 500;
    private static final int TIMER_DELAY = 20;
    private List<Surface> surfaces = new ArrayList<>();

    public ExampleGraphics2() {
        new Timer(TIMER_DELAY, new TimerListener()).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Surface surface : surfaces) {
            surface.draw(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class TimerListener implements ActionListener {
        private int index = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            index++;
            index %= 20;
            if (index == 0) {
                surfaces.add(new Surface(10, 10));
            }

            for (Surface surface : surfaces) {
                surface.runner();
            }
            repaint();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Example Graphics 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ExampleGraphics2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}