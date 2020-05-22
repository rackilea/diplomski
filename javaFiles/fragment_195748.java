final class HttpRequestCopyFilter implements Filter {

private final OutputStream copyOutput;

public HttpRequestCopyFilter(OutputStream copyOutput) {
    this.copyOutput = copyOutput;
}

public void init(FilterConfig arg0) throws ServletException {
}

public void destroy() {
}

private void flushCopy() throws IOException {
    copyOutput.flush();
}

public void doFilter(ServletRequest req, ServletResponse resp,
        FilterChain fc) throws IOException, ServletException {
    HttpServletRequest httpReq = (HttpServletRequest) req;
    HttpServletResponse httpResp = (HttpServletResponse) resp;

    HttpServletRequestWrapper requestWrapper =
            new HttpServletRequestWrapper(httpReq) {

                @Override
                public ServletInputStream getInputStream()
                        throws IOException {
                    final ServletInputStream original =
                            super.getInputStream();

                    return new ServletInputStream() {

                        @Override
                        public int read() throws IOException {
                            int c = original.read();
                            if (c >= 0) {
                                copyOutput.write(c);
                                flushCopy();
                            }
                            return c;
                        }

                        @Override
                        public int read(byte[] b) throws IOException {
                            int count = original.read(b);
                            if (count >= 0) {
                                copyOutput.write(b, 0, count);
                                flushCopy();
                            }
                            return count;
                        }

                        @Override
                        public int read(byte[] b, int off, int len)
                                throws IOException {
                            int count = original.read(b, off, len);
                            if (count >= 0) {
                                copyOutput.write(b, off, count);
                                flushCopy();
                            }
                            return count;
                        }
                    };
                }
            };

    fc.doFilter(requestWrapper, httpResp);
}
}