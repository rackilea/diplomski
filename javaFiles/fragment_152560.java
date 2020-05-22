private MultiValueMap getAllHeaders(HttpServletRequest request) {
    MultiValueMap allHeaders = new MultiValueMap();
    List<String> headerNames = Collections.list((Enumeration<String>)request.getHeaderNames());
    for (String headerName : headerNames) {
        allHeaders.putAll(headerName, Collections.list((Enumeration<String>) request.getHeaders(headerName)));
    }

    return allHeaders;
}