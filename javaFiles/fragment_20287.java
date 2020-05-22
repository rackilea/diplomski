@ControllerAdvice
public class UniversalExceptionHandler
{
    @ExceptionHandler(SomeException::class)
    fun handleBadRequests(ex: Throwable, response: HttpServletResponse){
        // .. some logic
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.message)
    }
}