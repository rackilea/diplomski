// HSSFWorkbook, File
NPOIFSFileSystem fs = new NPOIFSFileSystem(new File("file.xls"));
HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);
....
fs.close();

// HSSFWorkbook, InputStream, needs more memory
NPOIFSFileSystem fs = new NPOIFSFileSystem(myInputStream);
HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);
....
fs.close();