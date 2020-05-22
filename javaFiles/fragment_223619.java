package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.ConnectionManager;

@MultipartConfig(location="/tmp", fileSizeThreshold=1048576, maxFileSize=20848820, maxRequestSize=418018841)
public class Upload extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filePart=request.getPart("image");`// Retrieves <input type="file" name="image">`
        String filePath = filePart.getSubmittedFileName();//Retrieves complete file name with path and directories 
        Path p = Paths.get(filePath); //creates a Path object
        String fileName = p.getFileName().toString();//Retrieves file name from Path object
        InputStream fileContent = filePart.getInputStream();//converts Part data to input stream

        Connection conn=ConnectionManager.getConnection();
        int  len=(int) filePart.getSize();
        String query = ("insert into IMAGETABLE(ID,NAME,LENGTH,IMAGE) VALUES(?,?,?,?)");


        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 5);
            pstmt.setString(2, fileName);
            pstmt.setInt(3, len);
            pstmt.setBinaryStream(4, fileContent, len);
            success=pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error : "+ex.getMessage());
        }finally{
            try{
                if(fileContent!=null)fileContent.close();
                if(conn!=null)conn.close();
            }catch(IOException | SQLException ex){
                System.out.println("Error : "+ex.getMessage());
            }
        }

    }

}