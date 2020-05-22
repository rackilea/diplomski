import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultipleComponentsInRow {

    public static final int ROWS = 3;
    public static final int COLS = 4;

    private JFrame frame;
    private JPanel flowLayoutPanel;
    private JPanel gridLayoutPanel;

    private JTextField[][] flowFields;
    private JTextField[][] gridFields;

    private void createAndShowGui() {
        frame = new JFrame("Multiple Components In Row");

        flowFields = new JTextField[ROWS][COLS];
        gridFields = new JTextField[ROWS][COLS];

        flowLayoutPanel = new JPanel();
        flowLayoutPanel.setLayout(new BoxLayout(flowLayoutPanel, BoxLayout.PAGE_AXIS));

        gridLayoutPanel = new JPanel();
        gridLayoutPanel.setLayout(new GridLayout(ROWS, 7));

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                flowFields[i][j] = new JTextField(2);
                gridFields[i][j] = new JTextField(2);
            }
        }

        //FlowLayout approach
        for (int i = 0; i < ROWS; i++) {
            JPanel pane = new JPanel();
            pane.setLayout(new FlowLayout());
            for (int j = 0; j < COLS; j++) {
                pane.add(flowFields[i][j]);
                switch (j) {
                    case 0:
                        pane.add(new JLabel(" x + "));
                        break;
                    case 1:
                        pane.add(new JLabel(" y + "));
                        break;
                    case 2:
                        pane.add(new JLabel(" z = "));
                        break;
                    default:
                        break;
                }
            }
            flowLayoutPanel.add(pane);
        }

        //GridLayout approach
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                gridLayoutPanel.add(gridFields[i][j]);
                switch (j) {
                    case 0:
                        gridLayoutPanel.add(new JLabel(" x + "));
                        break;
                    case 1:
                        gridLayoutPanel.add(new JLabel(" y + "));
                        break;
                    case 2:
                        gridLayoutPanel.add(new JLabel(" z = "));
                        break;
                    default:
                        break;
                }
            }
        }

        frame.setLayout(new GridLayout(1, 2, 5, 5));

        flowLayoutPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Flow Layout"));
        gridLayoutPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Grid Layout"));

        frame.add(flowLayoutPanel);
        frame.add(gridLayoutPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MultipleComponentsInRow().createAndShowGui();
    }
}