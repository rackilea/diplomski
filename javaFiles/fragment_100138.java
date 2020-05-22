import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyGridEg extends JPanel {
    private static final int SPACE = 6;
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int IMG_W = 80;
    private static final int SML_GAP = 3;
    private static final Color IMG_BACKG = new Color(240, 240, 240);
    private static final String TITLE = "Click on a Cell";

    private JLabel[][] labelGrid = new JLabel[ROWS][COLS];
    private Icon blankIcon = createIconDisk(new Color(0, 0, 0, 0));
    private Icon redIcon = createIconDisk(Color.RED);

    public MyGridEg() {
        MyMouse myMouse = new MyMouse();
        JPanel gridHolder = new JPanel(new GridLayout(ROWS, COLS, SPACE, SPACE));
        gridHolder.setBackground(Color.BLACK);
        for (int i = 0; i < labelGrid.length; i++) {
            for (int j = 0; j < labelGrid[i].length; j++) {
                JLabel label = new JLabel(blankIcon);
                label.addMouseListener(myMouse);
                labelGrid[i][j] = label;
                gridHolder.add(label);
            }
        }
        gridHolder.setBorder(BorderFactory.createLineBorder(Color.black, SPACE));

        JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20));

        JButton clearButton = new JButton(new ClearAction("Clear"));
        JPanel btnPanel = new JPanel();
        btnPanel.add(clearButton);

        setLayout(new BorderLayout());
        add(gridHolder, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_END);
        add(titleLabel, BorderLayout.PAGE_START);
    }

    private Icon createIconDisk(Color color) {
        BufferedImage img = new BufferedImage(IMG_W, IMG_W, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setBackground(IMG_BACKG);
        g2.clearRect(0, 0, IMG_W, IMG_W);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        int x = SML_GAP;
        int y = x;
        int width = IMG_W - 2 * x;
        int height = IMG_W - 2 * y;
        g2.fillOval(x, y, width, height);
        g2.dispose();
        return new ImageIcon(img);
    }

    private class MyMouse extends MouseAdapter {
        @Override
            public void mousePressed(MouseEvent e) {
                JLabel selected = (JLabel) e.getSource();
                Icon icon = selected.getIcon() == blankIcon ? redIcon : blankIcon;
                selected.setIcon(icon);
            }
    }

    private class ClearAction extends AbstractAction {
        public ClearAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (JLabel[] labelRow : labelGrid) {
                for (JLabel cell : labelRow) {
                    cell.setIcon(blankIcon);
                }
            }
        }
    }

    private static void createAndShowGui() {
        MyGridEg mainPanel = new MyGridEg();

        JFrame frame = new JFrame("MyGridEg");
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