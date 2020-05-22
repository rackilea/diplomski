import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class SwingTesting {

    private final JFrame frame;
    private final TablePane tablePane;
    private final JSplitPane splitPane;
    private final JPanel infoPanel;

    JTextField make = new JTextField(9);;
    JTextField color = new JTextField(7);;
    JTextField year = new JTextField(4);

    public SwingTesting() {
        tablePane = new TablePane();
        infoPanel = new JPanel(new FlowLayout(5));

        infoPanel.add(new JLabel("Make"));
        infoPanel.add(make);
        infoPanel.add(new JLabel("Color"));
        infoPanel.add(color);
        infoPanel.add(new JLabel("Year"));
        infoPanel.add(year);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tablePane, infoPanel);

        frame.add(splitPane);
        frame.pack();
        frame.setVisible(true);
    }

    class TablePane extends JPanel {

        private final JTable table;
        private final TableModel tableModel;
        private final ListSelectionModel listSelectionModel;

    private void setFields(int index) {
        make.setText(table.getValueAt(index, 0).toString());
        color.setText(table.getValueAt(index, 1).toString());
        year.setText(table.getValueAt(index, 2).toString());
    }

    private void clearFields() {
        make.setText("");
        color.setText("");
        year.setText("");
    }

    public TablePane() {
        table = new JTable();
        tableModel = createTableModel();
        table.setModel(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.add(table.getTableHeader(), BorderLayout.PAGE_START);
        table.setFillsViewportHeight(true);

        listSelectionModel = table.getSelectionModel();
        table.setSelectionModel(listSelectionModel);
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
        table.setSelectionModel(listSelectionModel);

        this.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.gridwidth = 3;
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.ipadx = 2;
    gbc.ipady = 2;
    gbc.weightx = 1;
    gbc.weighty = 1;
        this.add(new JScrollPane(table), gbc);
    }

    private TableModel createTableModel() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[] {"Car", "Color", "Year"}, 0
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        addTableData(model);
        return model;
    }

    private void addTableData(DefaultTableModel model) {
        model.addRow(new Object[] {"Nissan", "Black", "2007"});
        model.addRow(new Object[] {"Toyota", "Blue", "2012"});
        model.addRow(new Object[] {"Chevrolet", "Red", "2009"});
        model.addRow(new Object[] {"Scion", "Silver", "2005"});
        model.addRow(new Object[] {"Cadilac", "Grey", "2001"});
    }


    class SharedListSelectionHandler implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            String contents = "";

            if(lsm.isSelectionEmpty()) {
                System.out.println("<none>");
            } else {
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                if (minIndex==maxIndex) {
                    setFields(minIndex);
                } else {
                    clearFields();
                    for(int i = minIndex; i <= maxIndex; i++) {
                        if(lsm.isSelectedIndex(i)) {
                            for(int j = 0; j < table.getColumnCount(); j++) {
                                contents += table.getValueAt(i, j) + " ";
                            }
                        }
                    }
                    System.out.println(contents);
                }
            }
        }

    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingTesting();
            }
        });
    }
}