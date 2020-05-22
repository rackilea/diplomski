File myfile = new File("/tmp/test.txt");
String path = myFile.getAbsolutePath();
File dir = new File(path).getParentFile();
if (Desktop.isDesktopSupported()) {
    Desktop.getDesktop().open(dir);
}