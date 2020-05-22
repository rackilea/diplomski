private ModelAndView getModelAndView(Method handlerMethod, Object returnValue, ServletWebRequest webRequest)
        throws Exception {

    ResponseStatus responseStatusAnn = AnnotationUtils.findAnnotation(handlerMethod, ResponseStatus.class);
    if (responseStatusAnn != null) {
        HttpStatus responseStatus = responseStatusAnn.value();
        String reason = responseStatusAnn.reason();
        if (!StringUtils.hasText(reason)) {
            // this doesn't commit the response
            webRequest.getResponse().setStatus(responseStatus.value());
        }
        else {
            // this commits the response such that any more calls to write to the 
            // response are ignored
            webRequest.getResponse().sendError(responseStatus.value(), reason);
        }
    }
    /// snip
}