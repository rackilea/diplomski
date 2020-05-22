private String[] columnNames1 = {"First Name", "Last Name"};
private String[][] data1 = {{"Kathy", "Smith"},{"John","Doe"}};

private String[] columnNames2 = {"First Name", "Last Name"};
private String[][] data2 = {{"Kathy", "Smith"},{"John","Doe"}};

DefaultTableModel tableModel1 = new DefaultTableModel(data1, columnNames1);
DefaultTableModel tableModel2 = new DefaultTableModel(data2, columnNames2);

JTable jTable1 = new JTable(tableModel1);
JTable jTable2 = new JTable(tableModel1);

jTable1.getSelectionModel().addListSelectionListener(
                                   new ListSelectionListener()
{
     public void valueChanged(ListSelectionEvent event)
     {
          int index = jTable1.getSelectedRow();
          jTable2.removeRow(index);             

     }
});