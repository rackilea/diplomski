import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class ReversiPanel extends JPanel {
    private static final int SIDES = 8;
    private static final int ICON_LENGTH = 60;
    private static final Color BG = Color.BLACK;
    private static final Color LABEL_COLOR = Color.GREEN.darker();
    private JLabel[][] labelGrid = new JLabel[SIDES][SIDES];
    private Icon blankIcon;
    private Icon blackIcon;
    private Icon whiteIcon;

    public ReversiPanel() {
        blankIcon = createIcon(new Color(0, 0, 0, 0));
        blackIcon = createIcon(Color.BLACK);
        whiteIcon = createIcon(Color.WHITE);

        setBackground(BG);
        setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setLayout(new GridLayout(SIDES, SIDES, 1, 1));
        MyMouse myMouse = new MyMouse();
        for (int i = 0; i < labelGrid.length; i++) {
            for (int j = 0; j < labelGrid[i].length; j++) {
                JLabel label = new JLabel(blankIcon);
                label.setOpaque(true);
                label.setBackground(LABEL_COLOR);
                label.addMouseListener(myMouse);
                labelGrid[i][j] = label;
                add(label);
            }
        }
    }

    private Icon createIcon(Color color) {
        BufferedImage img = new BufferedImage(ICON_LENGTH, ICON_LENGTH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        int gap = 4;
        int w = ICON_LENGTH - 2 * gap;
        int h = w;
        g2.fillOval(gap, gap, w, h);
        g2.dispose();
        return new ImageIcon(img);
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            Icon icon = label.getIcon();
            if (icon == blankIcon) {
                label.setIcon(blackIcon);
            } else if (icon == blackIcon) {
                label.setIcon(whiteIcon);
            } else {
                label.setIcon(blankIcon);
            }
        }
    }

    private static void createAndShowGui() {
        ReversiPanel mainPanel = new ReversiPanel();

        JFrame frame = new JFrame("ReversiPanel");
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