String[] list = new String[10]; // for example
int count = 0;
while (rs.next()) {
    list[count] = rs.getString("FIRST_NAME");
    count++;
}
jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(list));