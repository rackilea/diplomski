// Create a FileOutputStream
FileOutputStream fos = new FileOutputStream("filename.txt");

// Write contents to file

// Always close the stream, preferably in a try-with-resources block
fos.close();

// The, convert the file contents to an input stream
final InputStream fileInputStream = new FileInputStream("filename.txt");