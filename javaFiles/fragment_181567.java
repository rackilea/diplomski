public Squeeze(FileInput inFile, FileOutput outFile)
{
int spaces = 0;
String line = "";
String trimmedLine = "";
while(inFile.hasMoreLines())
{
    line = inFile.readLine();
    trimmedLine = line.trim();
    spaces = line.length() - trimmedLine.length();
    outFile.println(Format.left(spaces, 4) + line);

}
outFile.close();
}