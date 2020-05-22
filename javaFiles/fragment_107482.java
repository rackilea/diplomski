import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
    super();
    // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        URL url = new URL("http://www.avajava.com/images/avajavalogo.jpg");
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.9.248.37", 18082));
        System.out.println(url.getFile().substring(url.getFile().lastIndexOf("/")+1, url.getFile().length()));
        URLConnection connection = url.openConnection(proxy);
        InputStream stream = connection.getInputStream();
        response.setHeader("Cache-Control", "no-cache");
        ServletContext context = getServletContext();
        String  mimeType = "application/octet-stream";
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=icon" + ".jpg");
        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",url.getFile().substring(url.getFile().lastIndexOf("/")+1, url.getFile().length()));
        response.setHeader(headerKey, headerValue);
        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = stream.read(buffer)) != -1) {
           outStream.write(buffer, 0, bytesRead);
       }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}