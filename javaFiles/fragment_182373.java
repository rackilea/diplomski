//this is where correct input from user is passed, no binding errors
@RequestMapping(produces = "application/json", method = RequestMethod.GET, value="/v1/test")
public
@ResponseBody
MyResponse getSomething(@RequestParam BigDecimal bd) {
    MyResponse r = new MyResponse();
    r.setBd(bd);
    return r;
}

//this will handle situation when there's exception during binding, for example you except number and user passess string (A123.00 for example)
@ExceptionHandler(TypeMismatchException.class)
public 
@ResponseBody
MyErrorResponse handleMyException(Exception exception, HttpServletRequest request) {
    //....
}