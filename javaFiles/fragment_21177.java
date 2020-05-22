private static final int DEFAULT_BUFFER_SIZE = 8192; // 8KB.
// ...

File file = createExcelFileSomehow();
// ...

response.reset();
response.setBufferSize(DEFAULT_BUFFER_SIZE);
response.setHeader("Content-Type", "application/vnd.ms-excel");
response.setHeader("Content-Length", String.valueOf(file.length()));
response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

BufferedInputStream input = null;
BufferedOutputStream output = null;

try {
    input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);
    output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

    byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
    for (int length; (length = input.read(buffer)) > -1;) {
        output.write(buffer, 0, length);
    }
} finally {
    if (output != null) try { output.close(); } catch (IOException ignore) {}
    if (input != null) try { input.close(); } catch (IOException ignore) {}
}