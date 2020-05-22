public class ExternalServiceMock extends HttpServlet{

    public static final int TIMEOUT_SECONDS = 13;
    public static final long K = 1000l;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Random rnd = new Random();
        try {
            Thread.sleep(rnd.nextInt(TIMEOUT_SECONDS) * K);
        } catch (InterruptedException e) { }
        final byte[] token = String.format("%10d", Math.abs(rnd.nextLong())).getBytes(ISO_8859_1);
        response.setContentType("text/plain");
        response.setCharacterEncoding(ISO_8859_1.name());
        response.setContentLength(token.length);
        response.getOutputStream().write(token);
    }

}