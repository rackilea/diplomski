import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.continuation.*;

public class cs extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws java.io.IOException {

    String reqId = req.getParameter("id");

    Continuation cc = ContinuationSupport.getContinuation(req);

    res.setContentType("text/plain");
    res.getWriter().println("Request: " + reqId + "\tstart:\t" + new Date());
    res.getWriter().flush();

    cc.setTimeout(2000);
    cc.suspend();

    res.getWriter().println("Request: " + reqId + "\tend:\t" + new Date());
    if (cc.isInitial() != true) {
      cc.complete();
    }
  }
}