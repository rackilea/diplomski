import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyGrid extends JPanel {
    public static final String ROW = "row";
    public static final String COL = "col";
    private static final int SIDES = 8;
    private static final int CELL_SZ = 60;
    private static final Dimension CELL_DIMENSION = new Dimension(CELL_SZ, CELL_SZ);
    private static final Color DARK = Color.GRAY;
    private static final int LT = 250;
    private static final Color LIGHT = new Color(LT, LT, LT);
    private JLabel[][] cells = new JLabel[SIDES][SIDES];
    private Icon whiteIcon;
    private Icon redIcon;

    public MyGrid() {
        whiteIcon = createIcon(LIGHT);
        redIcon = createIcon(Color.RED);
        MyMouse myMouse = new MyMouse();
        setLayout(new GridLayout(SIDES, SIDES));
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                JLabel cell = new JLabel();
                cell.setOpaque(true);
                cell.setPreferredSize(CELL_DIMENSION);
                cell.putClientProperty(ROW, row);
                cell.putClientProperty(COL, col);
                cell.addMouseListener(myMouse);
                Color bg = row % 2 == col % 2 ? LIGHT : DARK;
                if (bg.equals(DARK) && row < 3) {
                    cell.setIcon(redIcon);
                } else if (bg.equals(DARK) && row > 4) {
                    cell.setIcon(whiteIcon);
                }
                cell.setBackground(bg);
                cells[row][col] = cell;
                add(cell);
            }
        }
    }

    private Icon createIcon(Color color) {
        BufferedImage img = new BufferedImage(CELL_SZ, CELL_SZ, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int gap = 4;
        g2.setColor(color);
        g2.fillOval(gap, gap, CELL_SZ - 2 * gap, CELL_SZ - 2 * gap);
        g2.dispose();
        return new ImageIcon(img);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        MyGrid mainPanel = new MyGrid();
        JFrame frame = new JFrame("MyGrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}