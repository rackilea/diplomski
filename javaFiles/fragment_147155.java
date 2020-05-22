package com.me.coder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.GET;

/**
 *
 * @author Coder ACJHP
 */
@WebService(serviceName = "GetWriteToDB")
public class GetWriteToDB {

    /**
     * Web service operation
     *
     * @param id
     * @param name
     * @param location
     * @param date
     * @return
     */
    @GET
    @WebMethod(operationName = "insertUser")
    public boolean insertUser(@WebParam(name = "id") int id, @WebParam(name = "name") String name,
            @WebParam(name = "location") double location, @WebParam(name = "date") String date) {
        boolean insertStatus = false;
        final String host = "jdbc:mysql://localhost/onurDB";
        final String user = "onur";
        final String pass = "onurdb958";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GetWriteToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (
                Connection conn = DriverManager.getConnection(host, user, pass);
                Statement smt = conn.createStatement();) {
            String SQL = "INSERT INTO `GoogleLoc`(`ID`, `NAME`, `LOCATION`, `DATE`) VALUES ('" + id + "','" + name + "','" + location + "','" + date + "')";
            int x = smt.executeUpdate(SQL);
            if (x > 0) {
                insertStatus = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return insertStatus;
    }