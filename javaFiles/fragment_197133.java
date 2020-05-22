public class UploadServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private static int BUFFER_SIZE = 1024 * 1024 * 10;

public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    ServletFileUpload upload = new ServletFileUpload();

    boolean isMultipart = ServletFileUpload.isMultipartContent(req);
    if (!isMultipart) {
        resp.getWriter().println("File cannot be uploaded !");
        return;
    }

    FileItemIterator iter;
    try {
        iter = upload.getItemIterator(req);
        while (iter.hasNext()) {
            FileItemStream item = iter.next();
            String fileName = item.getName();
            String fieldName = item.getFieldName();
            String mime = item.getContentType();

            if (fieldName.equals("file")) {  // the name of input field in html
                InputStream is = item.openStream();
                try {
                    FileService fileService = FileServiceFactory.getFileService();
                    AppEngineFile file = fileService.createNewBlobFile(mime, fileName);
                    boolean lock = true;
                    FileWriteChannel writeChannel = fileService.openWriteChannel(file, lock);
                    byte[] b1 = new byte[BUFFER_SIZE];
                    int readBytes1;
                    while ((readBytes1 = is.read(b1)) != -1) {
                        writeChannel.write(ByteBuffer.wrap(b1, 0, readBytes1));
                    }
                    writeChannel.closeFinally();
                    String blobKey = fileService.getBlobKey(file).getKeyString();
                    Entity input = new Entity("Input");
                    input.setProperty("Input File", blobKey);
                    datastore.put(input);
                } catch (Exception e) {
                    e.printStackTrace(resp.getWriter());
                }
            }
        }
    } catch (FileUploadException e) {
        // log error here
    }
}
}