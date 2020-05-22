public class ImageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Image image = imageDAO.find(request.getPathInfo()); // Threadsafe.
        // ...
    }
}