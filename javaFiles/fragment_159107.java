private Map<String, Object> getErrorAttributes(HttpServletRequest request, WebRequest webRequest,
                                               boolean includeStackTrace) {

    RequestAttributes requestAttributes = new ServletRequestAttributes(request);
    return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace)

}