import java.awt.Color;
import java.awt.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Example of using a DefaultTableModel that holds a row of specific type
 * Example of hidden column determining color of cells
 * @author Pete
 *
 */
@SuppressWarnings("serial")
public class SimpleTableExampe extends JPanel {
    RestaurantEmployee[] employees = {
            new RestaurantEmployee("John", true, 1),
            new RestaurantEmployee("Bill", false, 2),
            new RestaurantEmployee("Sally", true, 3),
            new RestaurantEmployee("Frank", false, 4),
            new RestaurantEmployee("Jim", false, 5),
            new RestaurantEmployee("Imelda", true, 6)
    };
    private MyTableModel tableModel = new MyTableModel();
    private JTable table = new JTable(tableModel);

    public SimpleTableExampe() {
        MyRenderer renderer = new MyRenderer(Color.RED, Color.GREEN);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        add(new JScrollPane(table));
        for (RestaurantEmployee employee : employees) {
            tableModel.addEmployee(employee);
        }        
    }

    private static void createAndShowGui() {
        SimpleTableExampe mainPanel = new SimpleTableExampe();

        JFrame frame = new JFrame("SimpleTableExampe");
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