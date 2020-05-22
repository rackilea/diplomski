// all extensions from TXTfile
String[] extensions= {"txt","abc","xyz","wxy"}; 

JFileChooser fileChooser = new JFileChooser();
FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXTFILES",extensions);
fileChooser.setFileFilter(filter);

int returnVal = chooser.showOpenDialog(parent);
if(returnVal == JFileChooser.APPROVE_OPTION) {
System.out.println("You chose to open this file: " 
+fileChooser.getName(new File("ext.txt")));//or you can use getSelectedFile() that  user has choosen.
    }