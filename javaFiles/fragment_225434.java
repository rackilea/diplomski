import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ColoredOvals extends JPanel {
    public static final int CELL_WIDTH = 50;
    public static final int SIDE = 8;
    private JLabel[][] grid = new JLabel[SIDE][SIDE];
    private Icon emptyIcon;
    private Icon colorIcon;

    public ColoredOvals() {
        // so lines appear between cells
        setBackground(Color.BLACK);

        // empty icon is 50x50 in size, and with clear color
        emptyIcon = createIcon(new Color(0, 0, 0, 0));
        // icon with a RED disk 
        colorIcon = createIcon(Color.RED);

        // create a grid layout to hold the JLabels
        // the 1, 1 is for the empty space between cells to show the black line
        setLayout(new GridLayout(SIDE, SIDE, 1, 1)); 

        // line around the entire JPanel (if desired)
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // mouse listener that moves the icon to the selected cell:
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                clearGrid();  // all labels hold blank icon
                JLabel label = (JLabel) e.getSource();
                label.setIcon(colorIcon);  // selected JLabel holds disk
            }
        };

        // iterate through the grid 2D array, creating JLabels and adding
        // blank icon as well as a MouseListener
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new JLabel(emptyIcon); // blank icon
                grid[i][j].setOpaque(true);
                grid[i][j].setBackground(Color.WHITE);
                add(grid[i][j]);
                grid[i][j].addMouseListener(mouseListener);
            }
        }
    }

    public void clearGrid() {
        for (JLabel[] jLabels : grid) {
            for (JLabel jLabel : jLabels) {
                jLabel.setIcon(emptyIcon);
            }
        }
    }

    // code to create blank icon or disk icon of color of choice
    private Icon createIcon(Color color) {
        BufferedImage img = new BufferedImage(CELL_WIDTH, CELL_WIDTH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        int gap = 2;
        g2.fillOval(gap, gap, CELL_WIDTH - 2 * gap, CELL_WIDTH - 2 * gap);
        g2.dispose();
        return new ImageIcon(img);
    }

    private static void createAndShowGui() {
        ColoredOvals mainPanel = new ColoredOvals();

        JFrame frame = new JFrame("ColoredOvals");
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