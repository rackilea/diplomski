/* loop until the user entered a file that does not exist yet */
while(fc.getSelectedFile().exists()) { 
  result = JOptionPane.showConfirmDialog(fc, "The file name exists. Please input new File name", "New File Name", JOptionPane.OK_CANCEL_OPTION);
  fc.showSaveDialog(fc);
  /* return if user cancels */
  if(result == JOptionPane.CANCEL_OPTION) { 
    fc.cancelSelection();
    return;
  }
}

/* if the user finally selected a non existing file do whatever needs to be done. */
if (result == JOptionPane.OK_OPTION) {
  try { 
    String fileExt = ".mads";
    //create a buffered writer to write to a file
    BufferedWriter out = new BufferedWriter(new FileWriter(fc.getSelectedFile().getPath() + fileExt));
    out.write(textArea.getText());//write contents of the TextArea to the file
    out.close();//close the file stream
  } catch(Exception e){  //catch any exceptions and write to the console
    System.out.println(e.getMessage());
  }
  return;
}