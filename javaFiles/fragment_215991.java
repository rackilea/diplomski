while(Rs.next()){
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    String name = Rs.getString("name");
    String status = Rs.getString("status");                 
    model.addRow(new Object[]{name,status });                               
}
jTable1.setModel(model);