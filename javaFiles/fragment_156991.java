public String getUserName() {
    Enumeration<String> headerNames = servletRequest.getHeaderNames();
    while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        String headerValue = servletRequest.getHeader(headerName);
        System.out.println("Header Name:" + headerName + " " + headerValue);
    }       
    return servletRequest.getUserPrincipal().getName();
}