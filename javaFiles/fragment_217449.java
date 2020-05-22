package gui.table;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ThreeColumnDemo {

    public static class ThreeColumnModel extends DefaultTableModel {

        public ThreeColumnModel() {
            // Initialize with 3 rows 0 columns
            super(3, 0);

            // add columns with data for each row
            this.addColumn("First Column", new String[] {"Value1_1", "Value2_1", "Value3_1" });
            this.addColumn("Second Column", new String[] {"Value1_2", "Value2_2", "Value3_2" });
            this.addColumn("Third Column", new String[] {"Value1_3", "Value2_3", "Value3_3" });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {

            @Override
            public void run() {
                JFrame window = new JFrame("3-column demo");
                window.setPreferredSize(new Dimension(600, 400));
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JTable table = new JTable( new ThreeColumnModel() );

                // put the table in a scroll pane so column headers are visible
                window.add(new JScrollPane(table));
                window.pack();
                window.setLocationRelativeTo(null);
                window.setVisible(true);
            }
        });
    }
}