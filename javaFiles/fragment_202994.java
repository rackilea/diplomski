public class SomeServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Object attribute = servletContext.getAttribute("test");
        System.out.println(attribute.toString());
   }
}