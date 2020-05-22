import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;    
import javax.swing.*;

@SuppressWarnings("serial")
public class MyDraw extends JPanel {

    private static final Color RECT_COLOR = new Color(100, 200, 0);
    private int larg;
    private int lung;

    public MyDraw(int larg, int lung) {
        this.larg = larg;
        this.lung = lung;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(RECT_COLOR);
        g.fillRect(0, 0, larg, lung);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(larg, lung);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("MyDraw");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int larg = 512;
        int lung = 512;
        frame.getContentPane().add(new MyDraw(larg, lung));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}