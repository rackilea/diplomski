System.setProperty("apple.awt.fileDialogForDirectories", "true");
FileDialog fd = new FileDialog(this); 
fd.setDirectory(_projectsBaseDir.getPath()); 
fd.setLocation(50,50);
fd.setVisible(true); 
File selectedFile = new File(fd.getFile());
System.setProperty("apple.awt.fileDialogForDirectories", "false");