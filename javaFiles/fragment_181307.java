private void EditActionPerformed(java.awt.event.ActionEvent evt)        
{                                     

  try{
   int row = Table_customer.getSelectedRow();
   System.out.println("selected row : " + row);
   if(row < 0) {
      JOptionPane.showMessageDialog(parentDialog, "Must select row" ); 
      return;
   }
    ...
 }