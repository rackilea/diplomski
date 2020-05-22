try (InputStream is = getClass().getResourceAsStream("/application/Documenation.pdf")) {
    File file = File.createTempFile("Documentation", ".pdf");
    file.deleteOnExit();
    try (OutputStream os = new FileOutputStream(file)) {
        byte[] buffer = new byte[1024];
        int bytesRead = -1;
        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
    }
    Desktop.getDesktop().open(file);
} catch (IOException exp) {
    exp.printStackTrace();
}