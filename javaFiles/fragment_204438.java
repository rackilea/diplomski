File file = new File("c:/abc.jpg");

response.setContentType(getServletContext().getMimeType(file.getName()));
response.setHeader("Content-Length", String.valueOf(file.length()));
response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");

BufferedInputStream input = null;
BufferedOutputStream output = null;

try {
    input = new BufferedInputStream(new FileInputStream(file));
    output = new BufferedOutputStream(response.getOutputStream());

    byte[] buffer = new byte[10240];
    int length;
    while ((length = input.read(buffer)) > 0) {
        output.write(buffer, 0, length);
    }
} finally {
    if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
    if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
}