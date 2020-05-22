import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

  private static final String SERLVET = "HelloServlet";
  private static final String SERLVET_ONE = "HelloServletOne";
  private static final String SERLVET_TWO = "HelloServletTwo";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    processRequest(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    processRequest(req, resp);
  }

  private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
    String path = req.getServletPath();
    switch (path) {
      case SERLVET:
        // ... call your function1
        break;
      case SERLVET_ONE:
        // ... call your function2
        break;

      case SERLVET_TWO:
        // ... call your function3
        break;
      default:
        break;
    }

    // do something else
  }

}