<%@ page import= "java.io.*,java.lang.*,java.util.*,java.net.*,java.util.*,java.text.*"%>
    <%@ page import="javax.activation.*,javax.mail.*,org.apache.commons.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*"%>


    <%!
          public String sendMail(String to, String sub, String msg) {
            String res = null;      
            System.out.println("HI");      
            return res;
         }
     %>

    <%        
    String a = request.getParameter("to");
    if(a != null){
        sendMail(request.getParameter("to"),request.getParameter("sub"),request.getParameter("msg"));
    }
    %>
    <html>
    <head>
    <title>Send Email using JSP</title>
    </head>
    <body><center>
        <form action="#" method="post"> 
            <label>Email To</label><br />       
                <input type="text" name="to" /><br /> <br /> 
            <label>Subject</label><br />        
                <input type="text" name="sub" /><br /> <br /> 
            <label for="body">Message</label><br />
                <input type="text" name="msg" /><br /> <br /> 
            <input type="submit"/>
        </form>
    </center></body>
    </html>