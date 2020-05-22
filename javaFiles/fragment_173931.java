public class MD5ServletResponse extends HttpServletResponseWrapper {

    private final MD5ServletOutputStream output;
    private final PrintWriter writer;

    public MD5ServletResponse(HttpServletResponse response) throws IOException {
        super(response);
        output = new MD5ServletOutputStream(response.getOutputStream());
        writer = new PrintWriter(output, true);
    }

    public PrintWriter getWriter() throws IOException {
        return writer;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return output;
    }

    public byte[] getHash() {
        return output.getHash();
    }

}