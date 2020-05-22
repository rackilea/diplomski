FileReader reader = null;
 BufferedReader inFile = null;

try {
reader = new FileReader(file.getAbsolutePath());
inFile = new BufferedReader(reader);
FileWriter fwriter = new FileWriter(file.getAbsolutePath());
BufferedWriter outw = new BufferedWriter(fwriter);

while (inFile.readLine() != null) {
    String line = mixCase(inFile.readLine());
    outw.write(line);
}

} catch (IOException e) {
e.printStackTrace();
}finally
{
   if(infile != null)
   inFile.close();

   if(reader != null)
   reader .close();
}