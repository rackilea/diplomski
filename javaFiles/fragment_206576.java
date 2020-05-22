pst = conn.PrepareStatement("select * from employees where Name = ?;");
pst.setString(1,table_click);
pst.executeQuery();
if (!rs.isBeforeFirst()) {
                System.out.println("Empty ResultSet");
            }
else{

JTextField.setText(rs.getString("Name"));
}