import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TableFun extends JPanel {
    private Integer[][] DATA = {{1, 2}, {3, 4}, {5, 6}};
    private String[] COL_NAMES  = {"A", "B"};
    private DefaultTableModel model = new DefaultTableModel(DATA, COL_NAMES) {
        public java.lang.Class<?> getColumnClass(int columnIndex) {
            return Integer.class;
        };
    };
    private JTable table = new JTable(model);
    private JButton myButton = new JButton("My Button");

    public TableFun() {
        model.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                boolean valid = true;
                for (int row = 0; row < model.getRowCount(); row++) {
                    Integer valueA = (Integer) model.getValueAt(row, 0);
                    Integer valueB = (Integer) model.getValueAt(row, 1);

                    if (valueA == null || valueB == null || valueA.compareTo(valueB) > 0) {
                        valid = false;
                    }
                }
                myButton.setEnabled(valid);
            }
        });

        JPanel panel = new JPanel();
        panel.add(myButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(table));
        add(panel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        TableFun mainPanel = new TableFun();
        JFrame frame = new JFrame("TableFun");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}