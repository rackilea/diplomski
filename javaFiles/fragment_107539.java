public class UploadServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Create a factory for disk-based file items
        FileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        List<FileItem> items = upload.parseRequest(request);

        //this assumes that the uploaded file is the only thing submitted by the form
        //if not you need to iterate the list and find it
        FileItem wordFile = items.get(0);

        //get a stream that can be used to read the uploaded file
        InputStream inputStream = wordFile.getInputStream();

        //and the rest you already know...
    }
}