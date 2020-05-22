public class UserInfo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.getWriter().println("GET");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String userName = request.getParameter("username");
        getServletContext().log("# User name: " + userName);
        RequestDispatcher view = request.getRequestDispatcher("view.jsp");
        view.forward(request, response);
    }
}