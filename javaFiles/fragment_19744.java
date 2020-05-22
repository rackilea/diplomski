//read file to string using our utility method
String text = readFileContents("pathToTargetFile");

//find start index
int startIndex = text.indexOf("BeginText");

//find end index from start index.
int endIndex = text.indexOf("EndText",startIndex);

//grab the sub string of the text between these two values.
String targetText = text.subString(startIndex,endIndex);





//private utility method, reads file contents and returns as a string
private String readFileContents(String filePath){

BufferedReader reader = new BufferedReader( new FileReader (new File(filePath)));
String         line = null;
StringBuilder  stringBuilder = new StringBuilder();
String         ls = System.getProperty("line.separator");

while( ( line = reader.readLine() ) != null ) {
    stringBuilder.append( line );
    stringBuilder.append( ls );
}

return stringBuilder.toString();
}