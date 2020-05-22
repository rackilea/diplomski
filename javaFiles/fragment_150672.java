HttpServletRequest request = (HttpServletRequest) MessageContext.getCurrentThreadsContext().getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);

String clientIpAddress = request.getHeader("X-FORWARDED-FOR");

if (clientIpAddress == null) {
    clientIpAddress = request.getRemoteAddr();
}

System.out.println(clientIpAddress);