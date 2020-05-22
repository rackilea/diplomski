import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/** @see https://stackoverflow.com/questions/6873665 */
public class JavaGUI extends JPanel {

    private static final int ICON_COL = 0;
    private static final int DATE_COL = 1;
    private static final Icon icon = UIManager.getIcon("Tree.closedIcon");
    private final Calendar calendar = Calendar.getInstance();

    public JavaGUI() {
        CustomModel model = new CustomModel();
        JTable table = new JTable(model) {

            @Override
            public Component prepareRenderer(
                    TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (isRowSelected(row)) {
                    c.setBackground(Color.blue);
                } else {
                    c.setBackground(Color.white);
                }
                return c;
            }
        };
        for (int i = 1; i <= 16; i++) {
            model.addRow(newRow(i));
        }
        this.add(table);
    }

    private Object[] newRow(int i) {
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return new Object[]{icon, calendar.getTime()};
    }

    private static class CustomModel extends DefaultTableModel {

        private final String[] columnNames = {"Icon", "Date"};

        @Override
        public Class<?> getColumnClass(int col) {
            if (col == ICON_COL) {
                return Icon.class;
            } else if (col == DATE_COL) {
                return Date.class;
            }
            return super.getColumnClass(col);
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private void display() {
        JFrame f = new JFrame("JavaGUI");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JavaGUI().display();
            }
        });
    }
}