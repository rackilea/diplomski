<%@ page contentType="text/xml" %>
<%@ page import="java.io.*" %>    
<%
//dump out the file
BufferedReader in = new BufferedReader(new FileReader("path/to/file.xml"));
String line;
while((line = in.readLine())!=null){
    out.print(line);
}
in.close();
%>