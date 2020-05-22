public static void main(String args[])throws IOException {

  File file = new File("Hello1.txt");
  // creates the file
  file.createNewFile();
  // creates a FileWriter Object
  FileWriter writer = new FileWriter(file); 
  // Writes the content to the file
  writer.write("This\n is\n an\n example\n"); 
  writer.flush();
  writer.close();
}