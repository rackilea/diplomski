public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    // inspect handler object, look for marker interface, methods and/or annotations
    // perform pre-processing on the handler object
    // e.g. handler.updateViewAfterPost(request, response)
    ModelAndView mav = super.handle (request, response, handler);
    // post-processing on the handler object
    return mav;
}