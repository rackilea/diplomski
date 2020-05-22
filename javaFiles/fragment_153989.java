import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class Example2 extends JPanel {
    // enum Token {
    //     VIDE, CERCLE_BLEU, CERCLE_ROUGE
    // }
    private static final int ICON_W = 35;
    private JPanel[][] grid;

    public Example2(int[][] data) {
        int rows = data.length;
        int cols = data[0].length;

        setLayout(new GridLayout(rows, cols, 1, 1));
        setBorder(BorderFactory.createLineBorder(Color.red));
        setBackground(Color.BLACK);

        createGrid(data);
    }

    private void createGrid(int[][] data) {
        int rows = data.length;
        int cols = data[0].length;
        grid = new JPanel[rows][cols];
        MyMouse myMouse = new MyMouse();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = new JPanel();
                grid[r][c].setOpaque(true);
                Color color = data[r][c] == 0 ? Color.WHITE : Color.DARK_GRAY;
                grid[r][c].setBackground(color);
                grid[r][c].setPreferredSize(new Dimension(ICON_W, ICON_W));
                grid[r][c].addMouseListener(myMouse);
                add(grid[r][c]);

            }
        }
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            JPanel source = (JPanel) e.getSource();
            int r = -1;
            int c = -1;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == source) {
                        r = row;
                        c = col;
                        break;
                    }
                }
            }
            Color color = source.getBackground();

            System.out.printf("Cell: [%d, %d] color white: %b%n", c, r, color.equals(Color.WHITE));
        }
    }

    private static void createAndShowGui() {
        int[][] data = {
                {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {1, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        Example2 mainPanel = new Example2(data);

        JFrame frame = new JFrame("RIC Emergency Map");
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