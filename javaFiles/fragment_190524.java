// Open "filename.txt" for reading
BufferedReader in = new BufferedReader(new FileReader("filename.txt"));

// Get a single line from the file (you can call this repeatedly for multiple lines)
String line = in.readLine();

// Convert that string to a character array
char[] array = line.toCharArray();