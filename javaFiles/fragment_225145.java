public class HttpServletResponseImpl implements HttpServletResponse {
    private PrintWriter out = new PrintWriter(...);

    @Override
    public PrintWriter getWriter() {
        return this.out;
    }

    // other fields and methods
}