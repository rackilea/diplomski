/** @see https://stackoverflow.com/questions/9155596 */
public class NewJavaGUI extends JPanel {

    private final JTable table;

    public NewJavaGUI() {
        String[] colNames = {"C1", "C2", "C3"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0) {

            @Override
            public boolean isCellEditable(int row, int col) {
                // return your actual criteria
                return true;
            }

            @Override
            public Class getColumnClass(int col) {
                // return your actual type tokens
                return getValueAt(0, col).getClass();
            }
        };
        // Add data; note auto-boxing
        model.addRow(new Object[]{"A1", "A2", 42});
        model.addRow(new Object[]{"B1", "B2", 42d});
        model.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                // DML as indicated
            }
        });
        table = new JTable(model);
        this.add(table);
    }

    private void display() {
        JFrame f = new JFrame("NewJavaGUI");
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
                new NewJavaGUI().display();
            }
        });
    }
}