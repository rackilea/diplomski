public class ParameterServlet extends HttpServlet {

---

public void init(ServletConfig config) throws ServletException {
    super.init(config);
    ServletContext context = getServletContext();
    name= context.getInitParameter("param");
  }