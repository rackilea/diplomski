public class BlobServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String blobParameter = request.getParameter("blob-key");
    if (blobParameter == null) {
        response.sendError(404, "Missing 'blob-key' parameter.");
    }

    BlobKey blobKey = new BlobKey(blobParameter);

    response.setHeader("Cache-Control", "max-age=" + (15 * 60));   // 15 min
    BlobstoreServiceFactory.getBlobstoreService().serve(blobKey, response);
}
}