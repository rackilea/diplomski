@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyException.class)
    protected ResponseEntity<Object> handleMyException(MyException ex, WebRequest req) {
        Object resBody = "some message";
        return handleExceptionInternal(ex, resBody, new HttpHeaders(), HttpStatus.NOT_FOUND, req);
    }

}