public static void writeFile(OutputStream output, File file) throws IOException {
    InputStream input = null;
    byte[] buffer = new byte[10240]; // 10KB.
    try {
        input = new FileInputStream(file);
        for (int length = 0; (length = input.read(buffer)) > 0;) {
            output.write(buffer, 0, length);
        }
    } finally {
        if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
    }
}