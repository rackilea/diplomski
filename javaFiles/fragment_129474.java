@ControllerAdvice
public class DefaultControllerAdvice extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
            HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, "Supported media types: " + ex.getSupportedMediaTypes(),
                headers, status, request);
    }

}