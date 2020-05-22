public String getFileName(){
   JFileChooser fc = new JFileChooser();
   if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
     return fc.getSelectedFile().getName();
   else
     return "";
}