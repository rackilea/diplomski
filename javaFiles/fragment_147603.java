JTable table = new JTable();

DefaultTableModel model = (DefaultTableModel) table.getModel();
model.addColumn("id");
model.addColumn("name");

Object[] row = new Object[2];
row[0] = 1;
row[1] = "John";

model.addRow(row);

row = new Object[2];
row[0] = 2;
row[1] = "Jack";

model.addRow(row);

for (int i = 0; i < model.getRowCount(); i++) {
    for (int j = 0; j < model.getColumnCount(); j++) {
        System.out.println("column: " + model.getColumnName(j) + ", row #" + i + ", value: " + model.getValueAt(i, j));
    }
}