private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
    try {
        ArrayList<Customer> customerList = null;
        try {
            try {
                customerList = CustomerController.getAllCustomer();
            } catch (SQLException ex) {
                Logger.getLogger(veiwCustomerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel tableModel = (DefaultTableModel) customerTable.getModel();
        tableModel.setRowCount(0);
        for (Customer customer : customerList) {
            Object rowData[] = {customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary()};
            tableModel.addRow(rowData);
        }


    } catch (Exception ex) {
        Logger.getLogger(ViewCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
    }

}