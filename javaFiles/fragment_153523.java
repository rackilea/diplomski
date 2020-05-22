@ExceptionHandler
@ResponseBody
public ErrorResponse handleAPIException(APIException e, HttpServletResponse response) {
// Set any response attributes you need...
    return e; // or some other response
}