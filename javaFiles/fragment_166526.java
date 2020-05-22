package mypackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        File root = new File(getServletContext().getRealPath("/"));

        String main = "<jsp:include page=\"${page1}\" /><jsp:include page=\"${page2}\" />";
        write(main, new File(root, "main.jsp"));

        String page1 = "<p>We are in ${data1}";
        write(page1, new File(root, "page1.jsp"));
        request.setAttribute("page1", "page1.jsp");
        request.setAttribute("data1", "first jsp");

        String page2 = "<p>We are in ${data2}";
        write(page2, new File(root, "page2.jsp"));
        request.setAttribute("page2", "page2.jsp");
        request.setAttribute("data2", "second jsp");

        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    private static void write(String content, File file) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            writer.write(content);
        } finally {
            if (writer != null) try { writer.close(); } catch (IOException ignore) {}
        }
    }

}