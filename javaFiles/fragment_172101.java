String rows[] = (buf.toString()).split("\n");

DefaultTableModel tableModel = new DefaultTableModel();

for (String col:rows[0].split(separator))
    tableModel.addColumn(col);

for (int i = 1; i < rows.length; i++)
    tableModel.addRow(rows[i].split(separator));

table.setModel(tableModel);