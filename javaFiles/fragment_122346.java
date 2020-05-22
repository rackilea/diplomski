<%@page import="org.jsoup.nodes.Document"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String relativeWebPath = "newhtml.html"; //relative path to resource
String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath); //absolute path
File input = new File(absoluteDiskPath); //get actual file 
Document doc = Jsoup.parse(input, "UTF-8", "/"); //parse it
doc.getElementById("text").html("<strong>Hey!!!</strong>"); //append required text
out.print(doc.html()); //output it!
%>