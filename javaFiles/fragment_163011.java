<%
BufferedReader in = new BufferedReader(new 
FileReader("C:\\MYPATH\\MYPATH2\\Cats.txt"));
String line;
while((line = in.readLine()) != null)
           {
out.println(line);
}
in.close()
%>