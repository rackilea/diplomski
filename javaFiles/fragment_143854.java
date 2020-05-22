public class ResponseLoggingWrapper extends HttpServletResponseWrapper {
private static final Logger log = LoggerFactory.getLogger(ResponseLoggingWrapper.class);
private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
private long id;

/**
 * @param requestId and id which gets logged to output file. It's used to bind response with
 *                  response (they will have same id, currenttimemilis is used)
 * @param response  response from which we want to extract stream data
 */
public ResponseLoggingWrapper(Long requestId, HttpServletResponse response) {
    super(response);
    this.id = requestId;
}

@Override
public ServletOutputStream getOutputStream() throws IOException {
    final ServletOutputStream servletOutputStream = ResponseLoggingWrapper.super.getOutputStream();
    return new ServletOutputStream() {
        private TeeOutputStream tee = new TeeOutputStream(servletOutputStream, bos);

        @Override
        public void write(byte[] b) throws IOException {
            tee.write(b);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            tee.write(b, off, len);
        }

        @Override
        public void flush() throws IOException {
            tee.flush();
            logRequest();
        }

        @Override
        public void write(int b) throws IOException {
            tee.write(b);
        }

        @Override
        public boolean isReady() {
            return servletOutputStream.isReady();
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {
            servletOutputStream.setWriteListener(writeListener);
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
    byte[] toLog = toByteArray();
    if (toLog != null && toLog.length > 0)
        log.info(getId() + ": http response " + new String(toLog));
}

/**
 * this method will clear the buffer, so
 *
 * @return captured bytes from stream
 */
public byte[] toByteArray() {
    byte[] ret = bos.toByteArray();
    bos.reset();
    return ret;
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}