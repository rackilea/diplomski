import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class JPanelGridLayoutDemo  {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JPanel GridLayout Demo");

        int cols = 5, rows = 5;
        int innerCols = 15, innerRows = 15;

        // fill, remove margin, remove grid gaps
        frame.setLayout(new MigLayout("fill, insets 0, gapx 0, gapy 0"));

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                JPanel panel = new JPanel();
                panel.setBackground(new Color((int) (Math.random() * 0x1000000)));
                panel.setLayout(new MigLayout("fill, insets 0, gapx 0, gapy 0"));

                // cell position, fill, min-width 1, min-height 1
                frame.add(panel, String.format("cell %d %d, grow, w 1::, h 1::", col, row));

                for (int innerCol = 0; innerCol < innerCols; innerCol++) {
                    for (int innerRow = 0; innerRow < innerRows; innerRow++) {
                        JPanel innerPanel = new JPanel();
                        innerPanel.setBackground(new Color((int) (Math.random() * 0x1000000)));
                        panel.add(innerPanel, String.format("cell %d %d, grow, w 1::, h 1::", innerCol, innerRow));
                    }
                }
            }
        }

        frame.setSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}