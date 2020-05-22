@ControllerAdvice
public class BadExceptionHandler: ResponseEntityExceptionHandler()
{
    @ExceptionHandler(Throwable::class)
    @ResponseBody
    public fun onException(ex: Throwable): ResponseEntity<ErrorResponse>
    {
        val responseCode = ex.responseCode()
        val errorResponse = ErrorResponse(response = ResponseHeader(responseCode, ex.message))
        return ResponseEntity(errorResponse, responseCode.httpStatus());
    }
}