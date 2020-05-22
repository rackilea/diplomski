@ExceptionHandler(TypeMismatchException.class)
public
@ResponseBody
String typeMismatchExpcetionHandler(Exception exception, HttpServletRequest request) {
    return "type mismatch";
}

@ExceptionHandler(MissingServletRequestParameterException.class)
public
@ResponseBody
String missingParameterExceptionHandler(Exception exception, HttpServletRequest request) {
    return "missing param";
}

@ExceptionHandler(Exception.class)
public
@ResponseBody
String generalExceptionHandler(Exception exception, HttpServletRequest request) {
    return "general exception";
}