public class ResourceServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getPathInfo();
        if (path == null) { // It's /resource
            ...
        } else if (path.matches("/\\d+")) { // It's /resources/<id> with integer id
            ...
        }
    }
}