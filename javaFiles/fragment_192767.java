private byte[] readFile(String path) {
    File file = new File(path);
    try (FileInputStream fis = new FileInputStream(file);
    BufferedInputStream bis = new BufferedInputStream(fis)) {
        byte[] buffer = new byte[4096];
        int bytesRead;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((bytesRead = bis.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    } catch (IOException e) {
        // handle the exception
        return null;
    }
}