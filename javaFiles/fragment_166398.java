<%@page import="java.util.Vector"%>

<%
 Vector oRetVal = new Vector();
 try{
       oRetVal = uploadexcel.ReadCSV("C:\\test.csv"); // Just an example
    }catch(Exception e){

        e.printStackTrace();
    }
%>