public class RequestResponseLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //here you wrap the request and response into some resetable istream class
        HttpServletRequest requestToUse = new ResettableStreamHttpServletRequest(request);
        HttpServletResponse responseToUse = new ResettableStreamHttpServletResponse(response);

        //you read the request to log it
        byte[] payload = IOUtils.toByteArray(requestToUse.getReader(), requestToUse.getCharacterEncoding());      
        String body =  new String(payload, requestToUse.getCharacterEncoding());

        //here you log the body request
        log.(body);

        //let the chain continue
        filterChain.doFilter(requestToUse, responseToUse);

        // Here we log the response
        String response =  new String(responseToUse.toString().getBytes(), responseToUse.getCharacterEncoding());

        //since you can read the stream just once, you will need it again for chain to be able to continue, so you reset it
        ResettableStreamHttpServletResponse responseWrapper = WebUtils.getNativeResponse(responseToUse, ResettableStreamHttpServletResponse.class);
        if (responseWrapper != null) {
            responseWrapper.copyBodyToResponse(true);
        }
    }

}

    public class ResettableStreamHttpServletRequest extends HttpServletRequestWrapper {

    private byte[] rawData;
    private ResettableServletInputStream servletStream;

    public ResettableStreamHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        rawData = IOUtils.toByteArray(request.getInputStream());
        servletStream = new ResettableServletInputStream();
        servletStream.setStream(new ByteArrayInputStream(rawData));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        servletStream.setStream(new ByteArrayInputStream(rawData));
        return servletStream;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        servletStream.setStream(new ByteArrayInputStream(rawData));
        return new BufferedReader(new InputStreamReader(servletStream));
    }

}

    public class ResettableStreamHttpServletResponse extends HttpServletResponseWrapper {

    private ByteArrayServletOutputStream byteArrayServletOutputStream = new ByteArrayServletOutputStream();

    public ResettableStreamHttpServletResponse(HttpServletResponse response) throws IOException {
        super(response);
    }

    /**
     * Copy the cached body content to the response.
     *
     * @param complete whether to set a corresponding content length for the complete cached body content
     * @since 4.2
     */
    public void copyBodyToResponse(boolean complete) throws IOException {
        byte[] array = byteArrayServletOutputStream.toByteArray();
        if (array.length > 0) {
            HttpServletResponse rawResponse = (HttpServletResponse) getResponse();
            if (complete && !rawResponse.isCommitted()) {
                rawResponse.setContentLength(array.length);
            }
            rawResponse.getOutputStream().write(byteArrayServletOutputStream.toByteArray());
            if (complete) {
                super.flushBuffer();
            }
        }
    }

    /**
     * The default behavior of this method is to return getOutputStream() on the wrapped response object.
     */
    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return byteArrayServletOutputStream;
    }

    /**
     * The default behavior of this method is to return getOutputStream() on the wrapped response object.
     */
    @Override
    public String toString() {
        String response = new String(byteArrayServletOutputStream.toByteArray());
        return response;
    }

}