public static String fromFile(File file, Charset charset) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset))) {
        StringWriter out = new StringWriter();
        char[] cbuf = new char[8192];
        int read;
        while ((read = reader.read(cbuf)) != -1) {
            out.write(cbuf, 0, read);
        }
        return out.toString();
    }
}