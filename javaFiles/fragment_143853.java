/**
 * Request logging wrapper using proxy split stream to extract request body
 */
public class RequestLoggingWrapper extends HttpServletRequestWrapper {
private static final Logger log =  LoggerFactory.getLogger(RequestLoggingWrapper.class);
private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
private long id;

/**
 * @param requestId and id which gets logged to output file. It's used to bind request with
 *                  response
 * @param request   request from which we want to extract post data
 */
public RequestLoggingWrapper(Long requestId, HttpServletRequest request) {
    super(request);
    this.id = requestId;
}

@Override
public ServletInputStream getInputStream() throws IOException {
    final ServletInputStream servletInputStream = RequestLoggingWrapper.super.getInputStream();
    return new ServletInputStream() {
        private TeeInputStream tee = new TeeInputStream(servletInputStream, bos);

        @Override
        public int read() throws IOException {
            return tee.read();
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            return tee.read(b, off, len);
        }

        @Override
        public int read(byte[] b) throws IOException {
            return tee.read(b);
        }

        @Override
        public boolean isFinished() {
            return servletInputStream.isFinished();
        }

        @Override
        public boolean isReady() {
            return servletInputStream.isReady();
        }

        @Override
        public void setReadListener(ReadListener readListener) {
            servletInputStream.setReadListener(readListener);
        }

        @Override
        public void close() throws IOException {
            super.close();
            // do the logging
            logRequest();
        }
    };
}

public void logRequest() {
    log.info(getId() + ": http request " + new String(toByteArray()));
}

public byte[] toByteArray() {
    return bos.toByteArray();
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}
}