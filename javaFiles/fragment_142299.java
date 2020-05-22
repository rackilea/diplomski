package com.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZipFileServlet extends HttpServlet {

    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.
    private YourFileDAO yourFileDAO = YourDAOFactory.getYourFileDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String[] fileIds = request.getParameterValues("fileId");
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=\"allfiles.zip\"");
        ZipOutputStream output = null;
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];

        try {
            output = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE));

            for (String fileId : fileIds) {
                YourFileItem item = yourFileDAO.find(fileId);
                if (item == null) continue; // Handle yourself. The fileId may be wrong/spoofed.
                InputStream input = null;

                try {
                    input = new BufferedInputStream(item.getInputStream(), DEFAULT_BUFFER_SIZE);
                    output.putNextEntry(new ZipEntry(item.getName()));
                    for (int length = 0; (length = input.read(buffer)) > 0;) {
                        output.write(buffer, 0, length);
                    }
                    output.closeEntry();
                } finally {
                    if (input != null) try { input.close(); } catch (IOException logOrIgnore) { /**/ }
                }
            }
        } finally {
            if (output != null) try { output.close(); } catch (IOException logOrIgnore) { /**/ }
        }
    }

}