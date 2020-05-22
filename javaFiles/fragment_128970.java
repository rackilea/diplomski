import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/serverpath" })
public class ServerPath extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String link = "<li><a href=\"serverpath?path=%s\">%s</a>&nbsp;<input type=\"button\" value=\"select\" onclick=\"window.opener.document.getElementById('path').value = '%s'; window.close();\" /></li>";
        response.setContentType("text/html");
        try {
            String path = req.getParameter("path");
            if (path == null) {
                // take disk drives, for linux / is enough for me
                response.getOutputStream().print(String.format(link, "/", "/", "/"));
            } else {
                File file = new File(path); //read clicked file path and its sub paths.
                if (file.isDirectory()) {
                    File[] subDir = file.listFiles();
                    for (File file2 : subDir) {
                        if (file2.isDirectory()) {
                            response.getOutputStream().println(
                                    String.format(link, file2.getAbsolutePath(), file2.getAbsolutePath(), file2.getAbsolutePath()));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}