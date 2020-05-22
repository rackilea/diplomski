MyModel model = new MyModel();

List<String> lstRow = new ArrayList<String>(7);
for (int i = 0; i < d; i++) {
    lstRow.add("");
}
for (int i = 0; i < numOfDays[month]; i++) {
    if (((i + d) % 7 == 0)) {
        model.addRow(lstRow);
        lstRow = new ArrayList<String>(7);
    }
    lstRow.add(Integer.toString(i + 1));
}

if (lstRow.size() > 0) {
    while (lstRow.size() < 7) {
        lstRow.add("");
    }
    model.addRow(lstRow);
}

JTable table = new JTable(model);
// Kleopatra is so going to kill me for this :(
Dimension size = table.getPreferredScrollableViewportSize();
size.height = table.getRowCount() * table.getRowHeight();
table.setPreferredScrollableViewportSize(size);

JOptionPane.showMessageDialog(null, new JScrollPane(table));

public static class MyModel extends AbstractTableModel {

    public static final String[] DAY_NAMES = {"S", "M", "Tu", "W", "Th", "F", "S"};
    private List<List<String>> lstRowValues;

    public MyModel() {
        lstRowValues = new ArrayList<List<String>>(25);
    }

    @Override
    public int getRowCount() {
        return lstRowValues.size();
    }

    @Override
    public String getColumnName(int column) {
        return DAY_NAMES[column];
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<String> rowData = lstRowValues.get(rowIndex);
        return rowData.get(columnIndex);
    }

    public void addRow(List<String> lstValues) {
        lstRowValues.add(lstValues);

        fireTableRowsInserted(getRowCount(), getRowCount());
    }
}