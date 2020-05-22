package com.report.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class PdfReportDownload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PdfReportDownload() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try 
        {
            generatePdfReport(response);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void generatePdfReport(HttpServletResponse response) 
    {
        try 
        {
            Connection conn=null;
            ResultSet rs=null;
            JasperReport jasperReport = null;
            String query ="{CALL get_report_data()}";
            try 
            {   
                if(conn==null)
                {
                    try 
                    {
                        conn= MySQLConnection.getConnection();

                    } 
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }   
            CallableStatement cstmt = conn.prepareCall(query);

            rs = cstmt.executeQuery();

            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(rs);  

            jasperReport = JasperCompileManager.compileReport("E:\\Eclipse 2019-03 Workspace\\Report_Download\\static_land_report.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap <String, Object>(), resultSetDataSource);

            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();
            pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
            pdfExporter.exportReport();

            response.setContentType("application/pdf");
            response.setHeader("Content-Length", String.valueOf(pdfReportStream.size()));
            response.addHeader("Content-Disposition", "attachment; filename=Report.pdf;");

            OutputStream responseOutputStream = response.getOutputStream();
            responseOutputStream.write(pdfReportStream.toByteArray());
            responseOutputStream.close();
            pdfReportStream.close();
        } 
        catch (Exception e) 
        {
                System.out.println(e);
        }
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
    }

}