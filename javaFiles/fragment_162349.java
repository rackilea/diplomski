import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyScreen extends JPanel {
    private static final int PREF_W = 700;
    private static final int PREF_H = 500;
    private static final int LINE_WIDTH = 5;
    private static final Stroke STROKE = new BasicStroke((float) LINE_WIDTH);
    private static final int MAX_DATA_SIZE = 50;
    private static final int MAX_RANGE = 400;
    private List<Integer> displayData = new ArrayList<>();
    private Random random = new Random();

    public MyScreen() {
        for (int i = 0; i < MAX_DATA_SIZE; i++) {
            displayData.add(random.nextInt(MAX_RANGE) + 1);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // to do house-keeping painting
        super.paintComponent(g);

        // to smooth out graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (displayData == null) {
            return;
        }

        g2.setStroke(STROKE);
        int x = 0;
        for (Integer i : displayData) {
            g2.drawLine(x, x, 0, i);
            x += LINE_WIDTH;
        }
    }


    private static void createAndShowGui() {
        MyScreen mainPanel = new MyScreen();

        JFrame frame = new JFrame("My Screen");
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