private void jCBCustomersActionPerformed(java.awt.event.ActionEvent evt) {                                             
    Appointment app = new Appointment();
    this.jCBCustomers.removeAllItems();
    ArrayList<String> list =app.jcbNames();
    for (String str:list){
         this.jCBCustomers.addItem(str);
    }
}