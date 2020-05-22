import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.*;

public class TablePrepareRenderer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;

    public TablePrepareRenderer() {
        Object[] columnNames = {"Type", "Company", "Shares", "Price", "Boolean"};
        Object[][] data = {
            {"Buy", "IBM", new Integer(1000), new Double(80.50), false},
            {"Sell", "MicroSoft", new Integer(2000), new Double(6.25), true},
            {"Sell", "Apple", new Integer(3000), new Double(7.35), true},
            {"Buy", "Nortel", new Integer(4000), new Double(20.00), false}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;
            private Border outside = new MatteBorder(1, 0, 1, 0, Color.red);
            private Border inside = new EmptyBorder(0, 1, 0, 1);
            private Border highlight = new CompoundBorder(outside, inside);

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                int modelRow = convertRowIndexToModel(row);
                int modelColumn = convertColumnIndexToModel(column);
                if (!isRowSelected(modelRow)) {
                    if (modelColumn != 0 || modelRow != 0) {
                        comp.setBackground(Color.GREEN);
                    } else {
                        comp.setBackground(table.getBackground());
                    }
                }
                return comp;

                /*Component comp = super.prepareRenderer(renderer, row, column);
                JComponent jc = (JComponent) comp;
                Map attributes = (new Font("Serif", Font.PLAIN, 12)).getAttributes();
                //attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                if (!isRowSelected(row)) {
                comp.setForeground(Color.black);
                comp.setBackground(row % 2 == 0 ? Color.white : Color.orange);
                int modelRow = convertRowIndexToModel(row);
                String type = (String) getModel().getValueAt(modelRow, 0);
                if (type.equals("Sell")) {
                comp.setFont(new Font(attributes));
                comp.setForeground(Color.red);
                } else {
                comp.setFont(new Font("Serif", Font.BOLD, 12));
                }
                } else {
                comp.setFont(table.getFont());
                }
                jc.setBorder(BorderFactory.createCompoundBorder(jc.getBorder(), BorderFactory.createEmptyBorder(0, 0, 0, 5)));
                return comp;*/
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TablePrepareRenderer frame = new TablePrepareRenderer();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}