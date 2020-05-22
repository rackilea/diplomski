JFileChooser fc = new JFileChooser();
fc.showOpenDialog(null);
File selected = fc.getSelectedFile();
System.out.println("You selected " + selected);

File currentDirectory = fc.getCurrentDirectory();
// Hack alert
fc.setSelectedFile(new File(""));
fc.setCurrentDirectory(currentDirectory);

fc.showOpenDialog(null);
selected = fc.getSelectedFile();

System.out.println("You selected " + selected);