/*
 * Replace the server URL with the proxy server URL when called from a proxy server 
 */
@Override
public void doFilter(
    ServletRequest request, 
    ServletResponse response,
    FilterChain filterChain) throws IOException, ServletException 
{
    WsdlResponseWrapper myResponse = new WsdlResponseWrapper((HttpServletResponse) response);
    filterChain.doFilter(request, myResponse);
    boolean isResponseOutputStream = myResponse.getOutputStreamContent().length > 0;

    /*
     * The servlet response sent into this method only allows access to
     * getOutputStream or getWriter, not both. It will throw an
     * exception if an attempt is made to to access both.
     * 
     * If this reason, I'm checking the output stream first and writing
     * that content if it exists, then printing to the writer only if
     * the output stream is empty.
     */
    StringBuffer responseBuffer;
    if (isResponseOutputStream) {
         responseBuffer = new StringBuffer(new String(myResponse.getOutputStreamContent()));
    } else {
        responseBuffer = new StringBuffer(myResponse.getWriterContent());
    }

    // Change the URL when called from a proxy server
    if (request instanceof HttpServletRequest) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String requestedHostname = httpServletRequest.getHeader("x-forwarded-host");
        if ((null != requestedHostname) && !requestedHostname.isEmpty()) {
            String myHostname = httpServletRequest.getHeader("host");
            int myPort = httpServletRequest.getLocalPort();

            // change the hostname
            int index = responseBuffer.indexOf(myHostname);
            int length = myHostname.length();
            while (index > -1) {
                responseBuffer.replace(index, index+length, requestedHostname);
                index = responseBuffer.indexOf(myHostname);
            }

            // remove the port
            String portString = ":" + myPort;
            length = portString.length();
            index = responseBuffer.indexOf(portString);
            while (index > -1) {
                responseBuffer.replace(index, index+length, "");
                index = responseBuffer.indexOf(portString);
            }
        }
    }

    // forward the response
    if (isResponseOutputStream) {
        response.getOutputStream().write(responseBuffer.toString().getBytes());
    } else {
        response.getWriter().print(responseBuffer);
    }
}