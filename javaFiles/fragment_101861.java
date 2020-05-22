public void doFilter(ServletRequest request, final ServletResponse response, FilterChain chain) throws IOException, ServletException {
    final CopyPrintWriter writer = new CopyPrintWriter(response.getWriter());
    chain.doFilter(request, new HttpServletResponseWrapper((HttpServletResponse) response) {
        @Override public PrintWriter getWriter() {
            return writer;
        }
    });
    logger.log(writer.getCopy());
}