BufferedReader br = new BufferedReader(new FileReader(text));
String content;

while ((content = br.readLine()) != null) 
{
    String delims = "\\s";
    String[] tokens = content.split(delims);
}