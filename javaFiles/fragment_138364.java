@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = { InvalidAccountDataException.class })
    protected ResponseEntity<Object> handleGenericExceptions(InvalidAccountDataException ex, WebRequest request) {
        log.warn(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());      
    }

}