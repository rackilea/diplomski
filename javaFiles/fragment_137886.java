private void TheGeneActionPerformed(java.awt.event.ActionEvent evt)
{                       
    model.removeAllElements();               
    // TODO add your handling code here:
    int n = theFile.getGeneNumberFromFile();
    for (int i = 0; i < n; i++) {
      String str = theFile.getGeneNameFromFile( i );
      model.addElement(str);
   }
}