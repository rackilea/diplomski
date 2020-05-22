@ExceptionHandler(AjaxException.class)
@ResponseBody
public Exception handleException(AjaxException ex, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    return ex;
}