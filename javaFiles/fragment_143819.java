try {

   String hex = jtextfield.getText();
   boolean canI = CheckHexValue(hex); //Method for checkin' if 'hex' String fits some specific terms

   if (canI) {

      combobox.insertItemAt(hex, 0);
      combobox.setSelectedIndex(0);
   }
} catch (Exception e) {
   JOptionPane.showMessageDialog(null, e);
}