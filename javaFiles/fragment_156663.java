//Read File Line By Line
String currentLine = br.readLine();
while (currentLine != null)   {
     // Print the content on the console
     strLine = strLine + currentLine;
     currentLine = br.readLine();
}