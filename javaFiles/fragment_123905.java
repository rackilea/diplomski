@ControllerAdvice
public class AdviceController {
    //..
    @ExceptionHandler(NoHandlerFoundException.class)
    public String dealWithNoHandlerFoundException(CheckoutException e, HttpServletRequest httpServletRequest)   {
                return "error";
    }
}