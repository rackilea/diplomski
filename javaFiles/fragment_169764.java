package foo;

import java.io.File;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.JarFile;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.*;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main
{

  public static void main(String[] args) throws Exception
  {
    String webappDirLocation = "src/main/webapp/";

    Server server = new Server(8080);
    WebAppContext root = new WebAppContext();

    root.setContextPath("/");
    root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
    root.setResourceBase(webappDirLocation);

    root.setParentLoaderPriority(true);

    server.setHandler(root);

    server.start();
    server.join();
  }
}