Vector columnNames = new Vector();
columnNames.addElement("Table");

DefaultTableModel model = new DefaultTableModel(columnNames, 0);

while (resultSet.next()) 
{
    Vector row = new Vector();
    row.addElement( resultSet.getString(3) );
    model.addRow(row);
}

table = new JTable( model );
scrollPane.setViewportView( table );