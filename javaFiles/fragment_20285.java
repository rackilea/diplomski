data class ErrorResponse(val statusCode: Int,  val statusMessage: String, val message: String)

@ControllerAdvice
public class SomeExceptionHandler
{
    @ExceptionHandler(Throwable::class)
    @ResponseBody
    public fun onException(ex: Throwable): ResponseEntity<ErrorResponse>
    {
        val httpError = HttpStatus.BAD_REQUEST
        val errorResponse = ErrorResponse(httpError.value(), httpError.reasonPhrase, ex.message ?: "Bad Thing")
        return ResponseEntity(errorResponse, httpError);
    }
}