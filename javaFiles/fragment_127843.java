@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AmazonS3Exception.class)
    public final ResponseEntity<Object> handleAmazonS3Exception(AmazonS3Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(UNPROCESSABLE_ENTITY, ex.getLocalizedMessage(), ex.getErrors());
        return new ResponseEntity<>(apiError, UNPROCESSABLE_ENTITY);
    }
}