/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.ca.water.preciptemp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hdunsford
 */
public class DailyHydroServlet1 extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DailyHydroServlet1.class.getName());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");
        Connection conn = null;
        ResultSet result = null;
        PreparedStatement selectStmt = null;
        PrintWriter out;
        try {
            out = response.getWriter();
            conn = DBUtil.getConnection();
            if (request.getParameter("param1").equals("RED9")) {
                selectStmt = conn.prepareStatement("select * from TableName");
            } else if (request.getParameter("param1").equals("RED921")) {
                selectStmt = conn.prepareStatement("select * from TableName");
                result = selectStmt.executeQuery();

                while (result.next()) {

                    out.append(result.getString("PARTC_SSN"));
                    out.append(',');

                    out.append("\n");
                }
                out.flush();
                out.close();
            }
        } catch (Exception ex) {
            try{
                out.close();
            }catch(Exception e){
                //ignore
            }
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (selectStmt != null) {
                    selectStmt.close();
                    selectStmt = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }

            } catch (SQLException e) {
                DBUtil.log("Exception from ExcelReportServlet class, Method -createNoEcmatsRegDoc "
                                + e);
            }
        }

    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}