import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyScrollExample extends JPanel {
    private static final int MAX = 100;
    private MyPanel myPanel = new MyPanel(MAX);

    public MyScrollExample() {
        JScrollPane scrollPane = new JScrollPane(myPanel);
        scrollPane.getViewport().setPreferredSize(new Dimension(600, 200));
        add(scrollPane);
    }

    private static void createAndShowGui() {
        MyScrollExample mainPanel = new MyScrollExample();

        JFrame frame = new JFrame("MyScrollExample");
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

@SuppressWarnings("serial")
class MyPanel extends JPanel {
    private static final Color BG = Color.BLUE;
    private static final Color FG = Color.YELLOW;
    private static final int WIDTH_GAP = 30;
    private static final int HEIGHT_GAP = 100;
    private int max;

    public MyPanel(int max) {
        setBackground(BG);
        this.max = max;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(FG);

        for (int i = 0; i < max; i++) {
            g.drawString("" + i, i * WIDTH_GAP, HEIGHT_GAP);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        int w = (WIDTH_GAP + 1) * max; 
        int h = HEIGHT_GAP * 3;
        return new Dimension(w, h);
    }

}