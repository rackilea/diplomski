import java.awt.BorderLayout;
import java.awt.Component;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CurrencyTable extends JPanel {
    private static final String[] TABLE_HEADERS = { "Text", "Value" };
    private static final Object[][] DATA = { { "Foo", 1.1 }, { "Bar", 2.2 }, { "Bax", 3.3 } };
    private DefaultTableModel tableModel = new DefaultTableModel(DATA, TABLE_HEADERS);
    private JTable table = new JTable(tableModel);
    private NumberFormat myFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

    public CurrencyTable() {
        table.getColumnModel().getColumn(1).setCellRenderer(new CurrencyCellRenderer());

        setLayout(new BorderLayout());
        add(new JScrollPane(table));
    }

    private class CurrencyCellRenderer extends DefaultTableCellRenderer {

        @Override
        public final Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value == null) {
                value = 0.0;
            }
            value = myFormat.format(value);

            final Component result = super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);

            return result;
        }
    }

    private static void createAndShowGui() {
        CurrencyTable mainPanel = new CurrencyTable();

        JFrame frame = new JFrame("CurrencyTable");
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