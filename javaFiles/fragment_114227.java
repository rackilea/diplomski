@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object processValidationError(NotFoundException ex) {
        String result = ex.getErrorMessage();
        System.out.println("###########"+result);
        return ex;
    }
}