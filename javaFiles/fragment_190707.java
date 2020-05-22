import org.springframework.web.bind.MissingServletRequestParameterException;

@ControllerAdvice
class MissingServletRequestParameterExceptionHandler {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMissingParameter() {
        return "Your custom result";
    }
}