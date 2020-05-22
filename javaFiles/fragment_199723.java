// delete name of previously selected file, but stay in the same directory
File currentDirectory = fileChooser.getCurrentDirectory();
fileChooser.setSelectedFile(new File(""));
fileChooser.setCurrentDirectory(currentDirectory);

// reset current file filters
fileChooser.resetChoosableFileFilters();

// set new file filter
fileChooser.setFileFilter(new FileNameExtensionFilter("Excel 97", "xls"));

// the "All files" filter will be present too, unless you uncomment this
// fileChooser.setAcceptAllFileFilterUsed(false);