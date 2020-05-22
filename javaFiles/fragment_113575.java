import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.*;
import javax.servlet.*;


public class URLServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        URL urldemo = new URL("http://www.demo.com/");
        URLConnection yc = urldemo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();

    }
}