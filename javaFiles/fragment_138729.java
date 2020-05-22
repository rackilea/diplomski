DefaultTableModel model = new DefaultTableModel(columnNames, 0);

while (rs.next())
{
    ....
    model.addRow(...);
}

JTable table = new JTable(model);
JScrollPane scrollPane = new JScrollPane(table);
...