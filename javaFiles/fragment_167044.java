package cz.literak.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class JarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        setContentType(path, response);

        InputStream streamIn = null;
        try {
            streamIn = getClass().getResourceAsStream(path);
            PrintWriter writer = response.getWriter();
            int c;
            while ((c = streamIn.read()) != -1) {
                writer.write(c);
            }
        } catch (IOException e) {
            streamIn.close();
        }
    }

    private void setContentType(String path, HttpServletResponse response) {
        if (path.toLowerCase().endsWith(".css")) {
            response.setContentType("text/css");
        }
        // TODO other mime types
    }
}