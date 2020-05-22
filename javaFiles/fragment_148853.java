import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Test {
    private JFrame frame;
    private JPanel pane;
    private JPanel cellsPane;
    private MyCell[][] cells;
    private JButton button;
    private Timer timer;

    private int counter = 3;
    private boolean isFinished = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Test().createAndShowGui());
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        pane = new JPanel();
        cellsPane = new JPanel();

        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        cellsPane.setLayout(new GridLayout(4, 4, 5, 5));

        cells = new MyCell[4][4];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new MyCell(Color.WHITE);
                cellsPane.add(cells[i][j]);
            }
        }

        button = new JButton("Press me!");
        timer = new Timer(1000, listener);

        button.addActionListener(e -> {
            button.setEnabled(false);
            isFinished = false;
            updateCellsColors();
            timer.start();
        });

        pane.add(cellsPane);
        pane.add(button);

        frame.add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void updateCellsColors() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].setCellColor(isFinished ? Color.WHITE : Color.BLUE);
            }
        }
    }

    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (counter == 0) {
                timer.stop();
                counter = 3;
                isFinished = true;
                button.setEnabled(true);
                updateCellsColors();
            }
            if (isFinished) {
                button.setText("Press me!");
            } else {
                button.setText("You have " + counter + " seconds remaining");
            }
            counter--;
        }
    };
}

@SuppressWarnings("serial")
class MyCell extends JPanel {
    private Color cellColor;

    public Color getCellColor() {
        return cellColor;
    }

    public void setCellColor(Color cellColor) {
        this.cellColor = cellColor;
        this.setBackground(cellColor);
    }

    public MyCell(Color cellColor) {
        this.cellColor = cellColor;
        this.setOpaque(true);
        this.setBackground(cellColor);
    }

    @Override
    public Dimension getPreferredSize() {
        // TODO Auto-generated method stub
        return new Dimension(30, 30);
    }
}