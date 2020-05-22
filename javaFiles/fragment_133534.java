public class ServerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello World</h1>");
    }
}