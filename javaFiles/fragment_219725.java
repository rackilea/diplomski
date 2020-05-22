DefaultTableModel rs = MyDB.DataTable("SELECT `Activity` FROM `transactions` WHERE `Group` = '" + Gname.getText()+ "' OR `Group` = 'ALL'");
int columnCount = rs.getColumnCount();
int rowCount = rs.getRowCount();

List <Object> values = new ArrayList<Object>();
for (int rowIndex = 0; rowIndex < rowCount; rowIndex ++){
    for(int columnIndex = 0; columnIndex < columnCount; columnIndex++){
         Object value = rs.getValueAt(rowIndex , columnIndex );
         values.add(value);
    }
}
DefaultComboBoxModel dmc = new DefaultComboBoxModel(values.toArray());