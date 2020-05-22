// pretty standard open file with buffered reader.
File           file               = new File("inputFileName");
FileReader     fileReader         = new FileReader(file);
BufferedReader bufferedFileReader = new BufferedReader(fileReader);

// The string that will hold the content of each line.
String line;

// Read each line and store string content in line.
while((line=bufferedFileReader.readLine())!=null)
{
   // Create a tokenizer to split the string into tokens.
   StringTokenizer tokenizedLine= new StringTokenizer(line);

   // For each token in the current line so something
   while (while (tokenizedLine.hasMoreTokens()) 
   {
         System.out.println(tokenizedLine.nextToken());
   }
}