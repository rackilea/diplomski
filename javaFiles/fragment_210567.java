String[] columnNames = { "Username", "First Name", "Last Name", "Address" };
DefaultTableModel model = new DefaultTableModel(columnNames, 0);

for( BDetails detail : bList) 
{
    Vector<String> row = new Vector<String>();
    row.add(detail.getUserName());
    row.add(detail.getFirstName());
    row.add(detail.getLastName());
    row.add(detail.getAddress();
    model.addRow( row );
}

JTable table = new JTable( model );
JScrollPane scrollPane = new JScrollPane( table );
// add the scrollpane to the frame