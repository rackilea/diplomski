//Connect database 
String s = comboBox.getSelectedItem().toString();
String SQL = "SELECT * FROM `products` WHERE `Model` = '" + s + "'"; 
ResultSet rs = stmt.executeQuery( SQL );
while(rs.next())
{
    requiredtextfield.setText(rs.getString("ColumnNAme_of_database"));
}