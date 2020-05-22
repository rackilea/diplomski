package jetty;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SetCookieTest
{
    @SuppressWarnings("serial")
    public static class SetCookieAddHeaderServlet extends HttpServlet
    {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            resp.setContentType("text/plain");
            resp.addHeader("Set-Cookie","SID=31d4d96e407aad42; Path=/; Secure; HttpOnly");
            resp.addHeader("Set-Cookie","lang=en-US; Path=/; Domain=example.com");
            PrintWriter out = resp.getWriter();
            out.println("Hello From: " + this.getClass().getName());
        }
    }

    @SuppressWarnings("serial")
    public static class SetCookieAddCookieServlet extends HttpServlet
    {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            resp.setContentType("text/plain");

            // Set-Cookie: SID=31d4d96e407aad42; Path=/; Secure; HttpOnly
            Cookie sidCookie = new Cookie("SID","31d4d96e407aad42");
            sidCookie.setPath("/");
            sidCookie.setSecure(true);
            sidCookie.setHttpOnly(true);
            resp.addCookie(sidCookie);

            // Set-Cookie: lang=en-US; Path=/; Domain=example.com
            Cookie langCookie = new Cookie("lang","en-US");
            langCookie.setPath("/");
            langCookie.setDomain("example.com");
            resp.addCookie(langCookie);

            PrintWriter out = resp.getWriter();
            out.println("Hello From: " + this.getClass().getName());
        }
    }

    private static Server server;

    @BeforeClass
    public static void startServer() throws Exception
    {
        server = new Server(9090);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(SetCookieAddHeaderServlet.class,"/test-add-header");
        context.addServlet(SetCookieAddCookieServlet.class,"/test-add-cookie");
        server.setHandler(context);
        server.start();
    }

    @AfterClass
    public static void stopServer() throws Exception
    {
        server.stop();
    }

    /**
     * Issue simple GET request, returning entire response (including payload)
     * 
     * @param uri
     *            the URI to request
     * @return the response
     */
    private String issueSimpleHttpGetRequest(String path) throws IOException
    {
        StringBuilder req = new StringBuilder();
        req.append("GET ").append(path).append(" HTTP/1.1\r\n");
        req.append("Host: localhost\r\n");
        req.append("Connection: close\r\n");
        req.append("\r\n");

        // Connect
        try (Socket socket = new Socket("localhost",9090))
        {
            try (OutputStream out = socket.getOutputStream())
            {

                // Issue Request
                byte rawReq[] = req.toString().getBytes(StandardCharsets.UTF_8);
                out.write(rawReq);
                out.flush();

                // Read Response
                StringBuilder resp = new StringBuilder();
                try (InputStream stream = socket.getInputStream();
                        InputStreamReader reader = new InputStreamReader(stream);
                        BufferedReader buf = new BufferedReader(reader))
                {
                    String line;
                    while ((line = buf.readLine()) != null)
                    {
                        resp.append(line).append(System.lineSeparator());
                    }
                }

                // Return Response
                return resp.toString();
            }
        }
    }

    @Test
    public void testAddHeader() throws Exception
    {
        String response = issueSimpleHttpGetRequest("/test-add-header");
        System.out.println(response);
        assertThat("response", response, containsString("Set-Cookie: SID=31d"));
        assertThat("response", response, containsString("Set-Cookie: lang=en-US"));
    }

    @Test
    public void testAddCookie() throws Exception
    {
        String response = issueSimpleHttpGetRequest("/test-add-cookie");
        System.out.println(response);
        assertThat("response", response, containsString("Set-Cookie: SID=31d"));
        assertThat("response", response, containsString("Set-Cookie: lang=en-US"));
    }
}