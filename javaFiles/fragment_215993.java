DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
while(Rs.next()){
    //DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    String name = Rs.getString("name");
    String status = Rs.getString("status");                 
    model.addRow(new Object[]{name,status });                               
}
jtable1.setModel(model);