private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                               
      int row = tableAdvancePayment.getSelectedRow();
      AdvancePayment deletedPayment = payments.get(indexModel);
      model.deleteRow(row);
      //do something with deletedPayment
}