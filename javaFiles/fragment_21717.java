protected HttpServletRequest getHttpServletRequest() {
    TransportContext ctx = TransportContextHolder.getTransportContext();
    return ( null != ctx ) ? ((HttpServletConnection ) ctx.getConnection()).getHttpServletRequest() : null;
}

protected String getHttpHeaderValue( final String headerName ) {
    HttpServletRequest httpServletRequest = getHttpServletRequest();
    return ( null != httpServletRequest ) ? httpServletRequest.getHeader( headerName ) : null;
}