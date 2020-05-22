public class ImageServlet extends HttpServlet {

    private Image image;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.image = imageDAO.find(request.getPathInfo()); // Not threadsafe!! image is been shared among all requests.
        // ...
    }
}