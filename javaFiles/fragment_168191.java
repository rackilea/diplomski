ok_btnActionPerformed(java.awt.event.ActionEvent evt) { 

 boolean isEmpty = false;
 for (int i = 0; i < jTable1.getRowCount(); i++) { //for column 7
     if (jTable1.getValueAt(i, 7).toString().equals("")) {
           isEmpty = true;
           break;
     }
   }

   if (!notEmpty){
      //do somthing
      this.dispose();
   else{
      JOptionPaneShowMessageDialog(null,"you forget something!");
}