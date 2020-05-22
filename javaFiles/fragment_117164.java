final BufferedReader br = new BufferedReader(new FileReader("path to your file"));
final StringBuilder sb = new StringBuilder(); 
String nextLine = br.readLine();//skip first <depends>

while(nextLine != null && !nextLine.equals("</depends>"))//not the end of the file and not the closing tag
{
    sb.append(nextLine);
    nextLine = br.readLine();
}

final String completeString = sb.toString();