@Override
public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {

    HttpServletRequest servletRequest = (HttpServletRequest) request;
    HttpServletResponse servletResponse = (HttpServletResponse) response;

    HttpResponseCatcher wrapper = new HttpResponseCatcher(
            (HttpServletResponse) response);

    chain.doFilter(request, wrapper);

    final byte[] responseBytes = wrapper.getByteArray();

    String digest = getMd5Digest(responseBytes);

    String etag = '"' + digest + '"';
    // always store the ETag in the header
    servletResponse.setHeader("ETag", etag);

    String previousEtag = servletRequest.getHeader("If-None-Match");
    // compare previous token with current one
    if (previousEtag != null && previousEtag.equals(etag)) {
        servletResponse.sendError(HttpServletResponse.SC_NOT_MODIFIED);
        // use the same date we sent when we created the ETag the first time
        // through
        servletResponse.setHeader("Last-Modified",
                servletRequest.getHeader("If-Modified-Since"));
    } else {
        // first time through - set last modified time to now
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MILLISECOND, 0);
        Date lastModified = cal.getTime();
        servletResponse.setDateHeader("Last-Modified",
                lastModified.getTime());

        servletResponse.setContentLength(responseBytes.length);
        ServletOutputStream sos = servletResponse.getOutputStream();
        sos.write(responseBytes);
        sos.flush();
        sos.close();
    }
}