@RequestMapping("error/{errorId}")
public ModelAndView resourceNotFound(@PathVariable Integer errorId,
                                                   HttpServletRequest request) {
    //request.getAttribute("javax.servlet.forward.request_uri");
    String origialUri = (String) request.getAttribute(
                                               RequestDispatcher.FORWARD_REQUEST_URI);

    return new ModelAndView("root/error.jspx", "originalUri", origialUri);
}