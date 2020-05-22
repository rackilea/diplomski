import java.awt.*;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TableFilterSorter extends JPanel {

    private boolean DEBUG = false;
    private static final long serialVersionUID = 1L;

    public TableFilterSorter() {
        super(new BorderLayout(5, 5));
        final JTextField filterCpText = new JTextField();
        filterCpText.setFont(new Font("Serif", Font.BOLD, 28));
        filterCpText.setForeground(Color.BLUE);
        filterCpText.setBackground(Color.LIGHT_GRAY);
        JPanel filterCpPanel = new JPanel();
        filterCpPanel.setLayout(new BorderLayout(5, 5));
        filterCpPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        filterCpPanel.setBackground(Color.LIGHT_GRAY);
        filterCpPanel.setPreferredSize(new Dimension(300, 30));
        filterCpPanel.add(filterCpText, BorderLayout.CENTER);
        add(filterCpPanel, BorderLayout.NORTH);
        final JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 160));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        TableModel myTableModel = table.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myTableModel);
        table.setRowSorter(sorter);
        filterCpText.getDocument().addDocumentListener(new DocumentListener() {

            private void searchFieldChangedUpdate(DocumentEvent evt) {
                String text = filterCpText.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                    table.clearSelection();
                } else {
                    try {
                        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 4));
                        table.clearSelection();
                    } catch (PatternSyntaxException pse) {
                        JOptionPane.showMessageDialog(null, "Bad regex pattern",
                                "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void insertUpdate(DocumentEvent evt) {
                searchFieldChangedUpdate(evt);
            }

            @Override
            public void removeUpdate(DocumentEvent evt) {
                searchFieldChangedUpdate(evt);
            }

            @Override
            public void changedUpdate(DocumentEvent evt) {
                searchFieldChangedUpdate(evt);
            }
        });
    }

    private class MyTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        private String[] columnNames = {"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"};
        private Object[][] data = {
            {"Mary", "Campione", "Snowboarding", new Integer(5), false},
            {"Alison", "Huml", "Rowing", new Integer(3), true},
            {"Kathy", "Walrath", "Knitting", new Integer(2), false},
            {"Sharon", "Zakhour", "Speed reading", new Integer(20), true},
            {"Philip", "Milne", "Pool", new Integer(10), false},
            {"Mary", "Campione", "Snowboarding", new Integer(5), false},
            {"Alison", "Huml", "Rowing", new Integer(3), true},
            {"Kathy", "Walrath", "Knitting", new Integer(2), false},
            {"Sharon", "Zakhour", "Speed reading", new Integer(20), true},
            {"Philip", "Milne", "Pool", new Integer(10), false},};

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public Class<?> getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                        + " to " + value + " (an instance of " + value.getClass() + ")");
            }
            data[row][col] = value;
            fireTableCellUpdated(row, col);
            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();
            for (int i = 0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j = 0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TableFilterSorter newContentPane = new TableFilterSorter();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.setLocation(150, 150);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}