public static void main(String[] args) throws IOException {
    Socket s = new Socket();
    InputStream s_in = null;
    PrintWriter s_out = null;

    try {
        s.connect(new InetSocketAddress("data.pr4e.org", 80));
        System.out.println("Connected");
        s_out = new PrintWriter(s.getOutputStream(), true);
        s_in = s.getInputStream();
    } catch (UnknownHostException e) {
        System.err.println("Don't know about host");
        System.exit(1);
    }

    // Message to server
    String message = "GET http://data.pr4e.org/cover3.jpg HTTP/1.0\r\n\r\n";
    s_out.println(message);

    OutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Steff\\Desktop\\Java ejemplos\\cover3.jpg"));
    int count;
    byte[] buffer = new byte[4096];
    while ((count = s_in.read(buffer)) > 0) {
        out.write(buffer, 0, count);
    }
    out.close();
}