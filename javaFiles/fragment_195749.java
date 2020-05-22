final class HttpResponseCopyFilter implements Filter {

private final OutputStream copyOutput;

public HttpResponseCopyFilter(OutputStream copyOutput) {
    this.copyOutput = copyOutput;
}

public void init(FilterConfig arg0) throws ServletException {
}

public void destroy() {
}

public void doFilter(ServletRequest req, ServletResponse resp,
        FilterChain fc) throws IOException, ServletException {
    HttpServletRequest httpReq = (HttpServletRequest) req;
    HttpServletResponse httpResp = (HttpServletResponse) resp;

    HttpServletResponseWrapper responseWrapper =
            new HttpServletResponseWrapper(httpResp) {

                @Override
                public ServletOutputStream getOutputStream()
                        throws IOException {
                    final ServletOutputStream original =
                            super.getOutputStream();
                    return new ServletOutputStream() {

                        @Override
                        public void write(int b) throws IOException {
                            original.write(b);
                            copyOutput.write(b);
                            flush();
                        }

                        @Override
                        public void write(byte[] b) throws IOException {
                            original.write(b);
                            copyOutput.write(b);
                            flush();
                        }

                        @Override
                        public void write(byte[] b, int off, int len)
                                throws IOException {
                            original.write(b, off, len);
                            copyOutput.write(b, off, len);
                            flush();
                        }

                        @Override
                        public void flush() throws IOException {
                            original.flush();
                            copyOutput.flush();
                            super.flush();
                        }

                        @Override
                        public void close() throws IOException {
                            original.close();
                            copyOutput.flush(); // DON'T CLOSE COPY-OUTPUT !!!
                            super.close();
                        }
                    };
                }
            };

    fc.doFilter(httpReq, responseWrapper);
}
}