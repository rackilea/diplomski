public class FileFrameBetterStructured extends JFrame {
static JButton button;
static JTextField filterText;
staitc TableRowSorter<TableModel> tableRowSorter;

protected FileModel fileModel = new FileModel(); 
FileFrameBetterStructured()
{
    // Set Preferences
    setSize(500, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    // Create table
    FileModel fileModel = new FileModel();
    JTable FileTable = new JTable(fileModel);
    tableRowSorter = new TableRowSorter<TableModel>(fileModel);
    FileTable.setRowSorter(TableRowSorter);
    FileTable.setColumnSelectionAllowed(true);
    FileTable.setDefaultRenderer(Number.class, new BigRenderer(1000));
    JScrollPane JScrollPane = new JScrollPane(FileTable);
    getContentPane().add(JScrollPane, BorderLayout.CENTER);
    // Create textfilter
    JPanel panel = new JPanel(new BorderLayout());
    JLabel label = new JLabel("Filter");
    panel.add(label, BorderLayout.WEST);
    filterText = new JTextField("");
    panel.add(filterText, BorderLayout.CENTER);
    add(panel, BorderLayout.NORTH);
    button = new JButton("Filter");
    add(button, BorderLayout.SOUTH);
    setSize(300, 250);
    setVisible(true);      
}

public static void main(String args[]) {
    final FileFrameBetterStructured FileFrame = new FileFrameBetterStructured();

    // Integrate ActionListener for textfilter
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = filterText.getText();
            if (text.length() == 0) {
                TableRowSorter.setRowFilter(null);
            } else {
                TableRowSorter.setRowFilter(RowFilter.regexFilter(text));
            }
        }
    });
}
}