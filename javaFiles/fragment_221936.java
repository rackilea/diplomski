import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;

public class RemoveAddRows extends JFrame {

    private static final long serialVersionUID = 1L;
    private Object[] columnNames = {"Type", "Company", "Shares", "Price"};
    private Object[][] data = {
        {"Buy", "IBM", new Integer(1000), new Double(80.50)},
        {"Sell", "MicroSoft", new Integer(2000), new Double(6.25)},
        {"Sell", "Apple", new Integer(3000), new Double(7.35)},
        {"Buy", "Nortel", new Integer(4000), new Double(20.00)}
    };
    private JTable table;
    private DefaultTableModel model;

    public RemoveAddRows() {

        model = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                int firstRow = 0;
                int lastRow = table.getRowCount() - 1;
                int width = 0;
                if (row == lastRow) {
                    ((JComponent) c).setBackground(Color.red);
                } else if (row == firstRow) {
                    ((JComponent) c).setBackground(Color.blue);
                } else {
                    ((JComponent) c).setBackground(table.getBackground());
                }
                /*if (!isRowSelected(row)) {
                String type = (String) getModel().getValueAt(row, 0);
                c.setBackground("Buy".equals(type) ? Color.GREEN : Color.YELLOW);
                }
                if (isRowSelected(row) && isColumnSelected(column)) {
                ((JComponent) c).setBorder(new LineBorder(Color.red));
                }*/
                return c;
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        JButton button1 = new JButton("Remove all rows");
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                System.out.println("model.getRowCount() --->" + model.getRowCount());
            }
        });
        JButton button2 = new JButton("Add new rows");
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                Object[] data0 = {"Buy", "IBM", new Integer(1000), new Double(80.50)};
                model.addRow(data0);
                Object[] data1 = {"Sell", "MicroSoft", new Integer(2000), new Double(6.25)};
                model.addRow(data1);
                Object[] data2 = {"Sell", "Apple", new Integer(3000), new Double(7.35)};
                model.addRow(data2);
                Object[] data3 = {"Buy", "Nortel", new Integer(4000), new Double(20.00)};
                model.addRow(data3);
                System.out.println("model.getRowCount() --->" + model.getRowCount());
            }
        });
        JPanel southPanel = new JPanel();
        southPanel.add(button1);
        southPanel.add(button2);
        add(southPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        RemoveAddRows frame = new RemoveAddRows();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}