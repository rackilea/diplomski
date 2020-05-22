private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
   JFileChooser chooser=new JFileChooser();
   int returnVal = chooser.showOpenDialog(null);
   if (returnVal == JFileChooser.APPROVE_OPTION) {
     selectedFile = chooser.getSelectedFile();
     String filename=F.getName();
     jTextField1.setText(filename);
   }
}