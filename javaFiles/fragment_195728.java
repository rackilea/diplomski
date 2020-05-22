import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String name = request.getParameter("name");

        String fileType = "multipart/form-data";

        response.setContentType(fileType);

        response.setHeader("Content-disposition", "attachment; filename=" + name);

        File currentFolder = new File(".");
        File workingFolder = new File(currentFolder, "Sorted files");

        String root = workingFolder.getAbsolutePath();

        File file = new File(root + File.separator + name);

        OutputStream output = response.getOutputStream();
        FileInputStream input = new FileInputStream(file);

        byte[] buffer = new byte[4096];
        int lenght;

        while( ( lenght = input.read(buffer) ) > 0 ) {
            output.write(buffer, 0, lenght);
        }

        input.close();

        output.flush();
        output.close();

        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}