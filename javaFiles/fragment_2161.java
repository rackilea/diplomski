private static byte[] zipOutputStreamAndConvertToByteArray(InputStream inputStream) throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    try (ZipOutputStream zip = new ZipOutputStream(outputStream)) {
        zip.putNextEntry(new ZipEntry("file"));
        try (InputStream in = inputStream) { 
        // this try block can be replaced with IOUtils.copy or ByteStreams.copy
            byte[] buffer = new byte[4096];
            int len;
            while ((len = in.read(buffer)) > 0) {
                zip.write(buffer, 0, len);
            }
        }
        zip.closeEntry();
    }

    return outputStream.toByteArray();
}