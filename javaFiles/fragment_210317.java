// info.txt represents the path to the file
File someFile = new File("info.txt");

// Create String from File
try {
  String filecontent = FileUtils.readFileToString(someFile, Charset.defaultCharset());
  System.out.println(filecontent);

} catch (IOException e) {
  e.printStackTrace();
}

// Encode / Decode string here

// Write String to file     
try {
  FileUtils.writeStringToFile(someFile, "your new file content string", Charset.defaultCharset());
  System.out.println("Success!");

} catch (IOException e) {
  e.printStackTrace();
}