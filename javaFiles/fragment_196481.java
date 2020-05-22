import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

class SelectedColumnTest {

    private JTableHeader header;
    private Object selectedColumn = null;
    private String[] columnNames = {"String", "Integer", "Boolean"};
    private Object[][] data = {{"aaa", 12, true}, {"bbb", 5, false}, {"CCC", 92, true}};
    private TableModel model = new DefaultTableModel(data, columnNames) {

        private static final long serialVersionUID = 1L;

        @Override
        public Class<?> getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    };
    private JTable table = new JTable(model);

    public JComponent makeUI() {
        //table.setRowSelectionAllowed(true);
        //table.setCellSelectionEnabled(false);
        //table.setColumnSelectionAllowed(false);
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(table));
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.changeSelection(0, 0, false, false);
        return p;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(new SelectedColumnTest().makeUI());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}