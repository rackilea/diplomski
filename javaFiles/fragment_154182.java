<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
 </head>
 <body>
   <%
   String msg="206_John_help i m in trouble,delhi,อินเดีย_30.64741430_76.817313799";
   System.out.println("The original message "+msg);
   String result = java.net.URLEncoder.encode(msg, "UTF-8");
   System.out.println("The msg is "+result);
   String result1=java.net.URLDecoder.decode(result, "UTF-8");
   System.out.println("The decoded msg is "+result1);

   %>
   Original message <%=msg %><br />
   Encrypted message <%=result %> <br />
   Decrypted message <%=result1 %>
</body>
 </html>