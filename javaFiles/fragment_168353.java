TableModel model = table.getModel();
String colYear = model.getColumnName(2);
int colYearValue = Integer.valueOf((String) model.getValueAt(row, 2));

if (colYearValue == 3) {
    cell.setBackground(Color.cyan);
} else {
    cell.setBackground(Color.lightGray);
}