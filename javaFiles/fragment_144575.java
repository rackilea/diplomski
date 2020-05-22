import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class ShareTableModel extends JPanel {
    private static final Integer[][] DATA = { 
            { 1, 2, 3 }, 
            { 4, 5, 6 }, 
            { 7, 8, 9 } ,
            {10, 11, 12}, 
            {13, 14, 15}};
    private static final String[] COLS = { "A", "B", "C" };
    private static final int SPINNER_COUNT = 3;
    private DefaultTableModel tblModel = new DefaultTableModel(DATA, COLS);
    private JTable table1 = new JTable(tblModel);
    private JTable table2 = new JTable(tblModel);
    private JSpinner[] spinners = new JSpinner[SPINNER_COUNT];
    private MySorter2 sorter = new MySorter2(tblModel);

    public ShareTableModel() {
        JPanel addRowPanel = new JPanel();
        for (int i = 0; i < spinners.length; i++) {
            JSpinner spinner = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
            addRowPanel.add(spinner);
            spinners[i] = spinner;
        }
        addRowPanel.add(new JButton(new AddRowAction("Add Row", KeyEvent.VK_A)));

        table2.setRowSorter(sorter);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Table 1", new JScrollPane(table1));
        tabbedPane.add("Table 2", new JScrollPane(table2));

        setLayout(new BorderLayout());
        add(tabbedPane);
        add(addRowPanel, BorderLayout.PAGE_END);
    }

    private class MySorter2 extends TableRowSorter<DefaultTableModel> {
        public MySorter2(DefaultTableModel tableModel) {
            super(tableModel);
            setRowFilter(new RowFilter<DefaultTableModel, Integer>() {
                @Override
                public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Integer> entry) {
                    int modelRow = entry.getIdentifier();
                    return modelRow < getModelRowCount() - 1;
                }
            });
        }
    }

    private class AddRowAction extends AbstractAction {
        public AddRowAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer[] row = new Integer[spinners.length];
            for (int i = 0; i < row.length; i++) {
                row[i] = (Integer) spinners[i].getValue();
            }
            tblModel.addRow(row);
            sorter.sort();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("ShareTableModel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ShareTableModel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}