public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {
// We include a max byte size to protect against malicious requests, since this all has to be read into memory
public static final Integer MAX_BYTE_SIZE = 1_048_576; // 1 MB

private String _body;

public MultiReadHttpServletRequest(HttpServletRequest request) throws IOException {
    super(request);
    _body = "";

    InputStream bounded = new BoundedInputStream(request.getInputStream(), MAX_BYTE_SIZE);
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bounded));

    String line;
    while ((line = bufferedReader.readLine()) != null){
        _body += line;
    }
}

@Override
public ServletInputStream getInputStream() throws       IOException {
    final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(_body.getBytes());

    return new ServletInputStream() {
        public int read() throws IOException {
            return byteArrayInputStream.read();
        }

        @Override
        public boolean isFinished() {
            return byteArrayInputStream.available() == 0;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {

        }
    };
}

@Override
public BufferedReader getReader() throws IOException {
    return new BufferedReader(new InputStreamReader(this.getInputStream()));
}
}