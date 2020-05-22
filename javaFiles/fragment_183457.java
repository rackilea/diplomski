File input = new File("D:\\test\\test.txt");
File output = new File("D:\\test.txt");
try( FileInputStream source = new FileInputStream(input);
     OutputStream target = new FileOutputStream(output)){
    byte[] buffer = new byte[source.available()];
    source.read(buffer);
    target.write(buffer);
}
long modified = input.lastModified();
output.setLastModified(modified);