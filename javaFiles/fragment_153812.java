package org.eclipse.jetty.demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class VideoServerMain
{
    @SuppressWarnings("serial")
    public class IndexerServlet extends HttpServlet
    {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            resp.setContentType("text/html");

            PrintWriter out = resp.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Videos</title></head>");
            out.println("<body>");
            for (File file : baseDir.listFiles())
            {
                if (file.isFile() && file.getName().endsWith(".mp4"))
                {
                    String encodedFilename = URLEncoder.encode(file.getName(), "UTF-8");
                    out.println("<video style=\"width: 400px; height: 300px\" controls loop>");
                    out.printf("  <source src=\"%s\" type=\"video/mp4\">%n",encodedFilename);
                    out.println("</video>");
                    out.printf("<p>%s</p>%n",file.getName());
                    out.println("<hr/>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.err.printf("ERROR: Usage %s [videos-dir]%n",VideoServerMain.class.getName());
            System.exit(-1);
        }

        File baseDir = new File(args[0]);
        if (!baseDir.exists() || !baseDir.isDirectory())
        {
            System.err.printf("ERROR: not a valid directory: %s%n",baseDir);
            System.exit(-1);
        }

        try
        {
            new VideoServerMain(baseDir).start();
        }
        catch (Throwable t)
        {
            t.printStackTrace(System.err);
        }
    }

    private final File baseDir;

    public VideoServerMain(File baseDir)
    {
        this.baseDir = baseDir;
    }

    public void start() throws Exception
    {
        Server server = new Server(8080);

        // Establish Scratch directory for the servlet context (used by JSP compilation)
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File scratchDir = new File(tempDir.toString(),"embedded-jetty-html5-vide-server");

        if (!scratchDir.exists())
        {
            if (!scratchDir.mkdirs())
            {
                throw new IOException("Unable to create scratch directory: " + scratchDir);
            }
        }

        // Setup the basic application "context" for this application at "/"
        // This is also known as the handler tree (in jetty speak)
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setAttribute("javax.servlet.context.tempdir",scratchDir);
        context.setResourceBase(baseDir.toURI().toASCIIString());

        // Add servlet to present html for found videos
        ServletHolder holderIndexer = new ServletHolder(new IndexerServlet());
        context.addServlet(holderIndexer,"/indexer");

        // Make sure that our welcome-file is the indexer servlet
        context.setWelcomeFiles(new String[]{ "indexer" });

        // Allow static file serving of videos themselves, via DefaultServlet
        // Add Default Servlet (must be named "default")
        ServletHolder holderDefault = new ServletHolder("default",DefaultServlet.class);
        holderDefault.setInitParameter("resourceBase",baseDir.getAbsolutePath());
        holderDefault.setInitParameter("dirAllowed","true");
        holderDefault.setInitParameter("welcomeServlets","true");
        holderDefault.setInitParameter("redirectWelcome","true");

        context.addServlet(holderDefault,"/");

        server.setHandler(context);

        server.start();
        server.join();
    }
}