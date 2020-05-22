private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
  if (selectedFile == null) {
    return;  // no file selected. Get out of here
  }
  String token1 = "";
  Scanner inFile1 = null;
  try {
    inFile1 = new Scanner(selectedFile);
  } catch (FileNotFoundException e) {
    e.printStackTrace();
    return;
  }

  // .....