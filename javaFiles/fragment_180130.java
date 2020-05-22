public static void main(String[] args) throws Exception {
    // get content of the "/usr/bin" directory
    ProcessBuilder pb = new ProcessBuilder("ls", "/usr/bin");
    pb.redirectErrorStream(true);

    Process p = pb.start();
    InputStream is = p.getInputStream();
    System.out.println(toString(is));
    is.close();
}

public static String toString(InputStream is) throws IOException {
    Writer writer = new StringWriter();
    char[] buffer = new char[1024];
    Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    int n;
    while ((n = reader.read(buffer)) != -1) {
        writer.write(buffer, 0, n);
    }
    return writer.toString();
}