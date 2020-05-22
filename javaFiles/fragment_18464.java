package ratsuk;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Melvin
 */
public class Tablero {

    private static final int HEIGHT = 8;
    private static final int WIDTH = 8;

    private JButton[][] grid;
    private Icon image;
    private JPanel panel;

    public Tablero() {
        panel = new JPanel(new GridLayout(HEIGHT, WIDTH));
        image = new ImageIcon();

        createFrame();

        createGrid();

        paintGrid();
    }

    private void createFrame() {
        JFrame frame = new JFrame ("Juego de Ratsuk");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private void createGrid() {
        grid = new JButton[HEIGHT][WIDTH];
        for (int row = 0; row < HEIGHT; row++) {
            for (int column = 0; column < WIDTH; column++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(40, 40));

                grid[row][column] = button;
                panel.add(button);
            }
        }
    }

    private void paintGrid() {
        for (int r = 0; r < HEIGHT; r++) {
            for (int t = 0; t < WIDTH; t++) {
                Color background = getBackgroundColor(r, t);

                grid[r][t].setBackground(background);
            }
        }
    }

    private Color getBackgroundColor(int r, int t) {
        Color background;
        if (r % 2 == 0 || r == 0) {
            if (t % 2 == 0 || t == 0) {
                background = Color.BLACK;
            } else {
                background = Color.WHITE;
            }
        } else {
            if (t % 2 == 0 || t == 0) {
                background = Color.WHITE;
            } else {
                background = Color.BLACK;
            }
        }
        return background;
    }

    public void caballo(final int row, final int column) {

        final JButton current = grid[row][column];

        current.setIcon(image);
        panel.repaint();

        addActionListeners(row, column, current);
    }

    private void addActionListeners(int row, int column, final JButton current) {
        current.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                current.setBackground(Color.RED);
            }
        });

        final int nextRow = row + 2;
        final int nextColumn = column - 1;
        if (tienebotton(nextRow, nextColumn)){
            JButton next = grid[nextRow][nextColumn];

            next.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent d) {
                    current.setIcon(null);

                    caballo(nextRow, nextColumn);
                }
            });
        }
    }

    private boolean tienebotton(int row, int column) {
        return  row >= 0 && row < HEIGHT && column >=0 && column < WIDTH;
    }

}