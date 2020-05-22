import java.awt.BorderLayout;


public class StackOverflow extends JDialog {

private final JPanel contentPanel = new JPanel();
private JTable table;
private JComboBox comboBox = new JComboBox();
private JButton button = new JButton("+");
private JButton button_1 = new JButton("-");
private JScrollPane scrollPane = new JScrollPane();
private List<String> list = new ArrayList<String>();

/**
 * Launch the application.
 */
public static void main(String[] args) {
    try {
        StackOverflow dialog = new StackOverflow();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

/**
 * Create the dialog.
 */
public StackOverflow() {
    setTitle("StackOverflow");
    setBounds(100, 100, 339, 228);

    comboBox.setModel(new DefaultComboBoxModel(new String[] {"ITEM 1", "ITEM 2", "ITEM 3", "ITEM 4", "ITEM 5", "ITEM 6"}));

    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {

        scrollPane.setBounds(10, 43, 303, 131);
        contentPanel.add(scrollPane);
        {
            table = new JTable();
            table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Item", "Count"
                }
            ));
            scrollPane.setViewportView(table);
        }
    }

    //Gets the table model and clear it
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);

    //Add comboBox items to table
    for (int i = 0; i < comboBox.getItemCount(); i++) 
        model.addRow(new Object[] { comboBox.getItemAt(i) , 0 });


    comboBox.setBounds(10, 12, 203, 20);
    contentPanel.add(comboBox);
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            String selectedItem = (String) comboBox.getSelectedItem();
            for (int i = 0; i < table.getRowCount(); i++) {
                String tableItem = (String) table.getValueAt(i, 0);
                int count = (Integer) table.getValueAt(i, 1)+1;
                if (selectedItem.equals(tableItem)) {
                    table.setValueAt(count, i, 1);
                }
            }
        }
    });

    button.setBounds(223, 11, 41, 23);
    contentPanel.add(button);
    button_1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            String selectedItem = (String) comboBox.getSelectedItem();
            for (int i = 0; i < table.getRowCount(); i++) {
                String tableItem = (String) table.getValueAt(i, 0);
                int count = (Integer) table.getValueAt(i, 1)-1;
                if (selectedItem.equals(tableItem)) {
                    table.setValueAt(count, i, 1);
                }
            }
        }
    });

    button_1.setBounds(272, 11, 41, 23);
    contentPanel.add(button_1);
}