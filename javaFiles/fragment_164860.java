@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler({SomeOtherException.class, ValidationsFatalException.class})
public @ResponseBody Object handleBadRequestExpection(HttpServletRequest req, Exception ex) {
    if(ex instanceof CustomBadRequestException) 
        return new CustomResponse(400, HttpStatus.BAD_REQUEST, ex.getMessage()); 
    else 
        return new DetailedCustomResponse(400, HttpStatus.BAD_REQUEST, ex.getMessage(),((ValidationsFatalException) ex).getDetails()); 
}