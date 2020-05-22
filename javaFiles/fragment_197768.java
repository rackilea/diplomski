FileInputStream fstream = new FileInputStream("textfile.txt");
DataInputStream in = new DataInputStream(fstream);
BufferedReader br = new BufferedReader(new InputStreamReader(in));
String strLine;

while ((strLine = br.readLine()) != null)   { // Until file has content, keep reading
String[] temp;
temp = strLine.split("$$$");

//using string.split() with the delimiter to get back all the sub-strings.

}