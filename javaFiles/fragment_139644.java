<%@ page language="java" import="net.sf.jasperreports.engine.*,net.sf.jasperreports.engine.export.*" %>  
<%@ page import="org.apache.commons.lang.time.*" %>  
<%@ page import="java.sql.*,java.io.*" %>
<%
 String filename = request.getParameter("filename");
 String reporttype = request.getParameter("reporttype");
 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 Connection conn = DriverManager.getConnection("jdbc:sqlserver://[servername]\\[instancename];databaseName=[databasename][:portnumber(remove when dynamic port is used)];integratedSecurity=True");
           System.out.println("Connection Established");
 String path = application.getRealPath("/");

 JasperPrint jasperPrint = JasperFillManager.fillReport(path + "/" + filename, null, conn);
 System.out.println("Report Created...");

 OutputStream ouputStream = response.getOutputStream();

 JRExporter exporter = null;

 if( "pdf".equalsIgnoreCase(reporttype) )
 {
      response.setContentType("application/pdf");
      exporter = new JRPdfExporter();
      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
 }
 else if( "html".equalsIgnoreCase(reporttype) )
 {
      exporter = new JRHtmlExporter();
      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
 }
 else if( "xls".equalsIgnoreCase(reporttype) )
 {
      response.setContentType("application/xls");
      response.setHeader("Content-Disposition", "inline; filename=\"file.xls\"");

      exporter = new JRXlsExporter();
      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
 }
 try 
 {
      exporter.exportReport();
 } 
 catch (JRException e) 
 {
      throw new ServletException(e);
 }
 finally
 {
      if (ouputStream != null)
      {
           try
           {
                ouputStream.close();
           }
           catch (IOException ex)
           {
           }
      }
 }
%>