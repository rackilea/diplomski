<%@ page contentType="text/html;charset=windows-1252" %>
<%@ page import = "java.util.*" %>
 <%@ page import ="java.sql.*" %>
  <%@ page import="java.sql.Blob.*" %>
  <%@ page import="org.apache.commons.fileupload.*"%>
  <%@ page import ="javax.naming.InitialContext" %>
    <%@ page import = "java.io.*"%>
      <%@ page import ="java.sql.PreparedStatement.*" %>
        <%@ page import="oracle.sql.BLOB"%>
          <%@ page import="java.sql.Blob"%>
            <%@ page import="org.iibf.claim.dto.*"%> 
             <html>
               <head>
                <title>DownLoad File Form</title>
                  <form name="upload1" method=get ENCTYPE='multipart/form-data'>
                    <link href="../stylesheet/style.css" rel="stylesheet" type="text/css" />
                    <script>
                     alert("Download pdf");
                    </script>
                   </head>
                  <body>

                  <form name="RT_DownloadAttach">

 <%
  String PurchaseId=request.getParameter("TrnID");
   System.out.println(PurchaseId+ "<- trnid ");

   LM_DownLoadAttachDto objRT_DownLoadAttachDTO      =org.iibf.claim.util.CLA_Conveyance_recommenHelper.getSelectedDownload(Purchas     eId);
byte[] ba =objRT_DownLoadAttachDTO.getAttachmentByte(); 
//java.io.InputStream fis = rs.getBlob(2).getBinaryStream();
 String fileName = objRT_DownLoadAttachDTO.getName();
 OutputStream os = response.getOutputStream();
 response.setContentType("text/ascii");
 response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
  response.setHeader("cache-control", "no-cache");
  os.write(ba);
os.close(); %>
     <div id="body11">
   </body>
  <html>