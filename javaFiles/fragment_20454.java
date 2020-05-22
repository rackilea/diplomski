Long imageId = Long.valueOf(request.getPathInfo().substring(1)); // 123
Image image = imageDAO.find(imageId); // Get Image from DB.
// Image class is just a Javabean with the following properties:
// private String filename;
// private Long length;
// private InputStream content;

response.setHeader("Content-Type", getServletContext().getMimeType(image.getFilename()));
response.setHeader("Content-Length", String.valueOf(image.getLength()));
response.setHeader("Content-Disposition", "inline; filename=\"" + image.getFilename() + "\"");

BufferedInputStream input = null;
BufferedOutputStream output = null;

try {
    input = new BufferedInputStream(image.getContent());
    output = new BufferedOutputStream(response.getOutputStream());
    byte[] buffer = new byte[8192];
    for (int length = 0; (length = input.read(buffer)) > 0) {
        output.write(buffer, 0, length);
    }
} finally {
    if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
    if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
}