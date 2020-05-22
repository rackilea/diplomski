@MultipartConfig
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String filename = getFilename(filePart);
        InputStream filecontent = filePart.getInputStream();
        // ... (do your job here)
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

}