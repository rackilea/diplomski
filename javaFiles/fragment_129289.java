...
int column = 0;
int row = table_1.getSelectedRow();
if (row == -1) {
    JOptionPane.showMessageDialog(null, "Please select a row to delete!");
} else {
    String id = table_1.getModel().getValueAt(row, column).toString();
    ...
}