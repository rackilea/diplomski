package com.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Entity;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService()
@Entity
@Path("/user")
public class MyAccount
{
    @POST
    @Path("/fetch")
    @WebMethod(operationName = "insert")
    public String insert(@FormParam("name") String name) 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
            String query = "insert into CUSTOMER"+"(NAME) VALUES"+"(?)";

            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,name);
            st.executeUpdate();     
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return"Record inserted successfully";
    }

    @GET
    @Path("/retrive")
    @Produces("text/html")
    @WebMethod(operationName = "retrive")
    public String retrive() 
    {
        ResultSet rs = null;
        String details = ""; 
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");

            String query = "select ID,NAME from CUSTOMER";

            PreparedStatement st = con.prepareStatement(query);
            rs = st.executeQuery();

            details = "<html><body>"; 
            details = details + "<table border=1>";
            details = details + "<tr><td><Strong>Id </Strong></td>" +
                                    "<td><Strong>Name </Strong></td>" + "</tr>";
            while (rs.next()) 
            {
                details = details + "<tr><td>" + rs.getInt("ID") + "</td>" +
                                        "<td>" + rs.getString("NAME") + "</td></tr>";
            }
            details += "</table></body></html>"; 
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }   
        return details;
    }
}