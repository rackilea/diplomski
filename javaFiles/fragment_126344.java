@ControllerAdvice
public class ExceptionConfiguration extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JsonMappingException.class) // Or whatever exception type you want to handle
    public ResponseEntity<SomeErrorResponsePojo> handleConverterErrors(JsonMappingException exception) { // Or whatever exception type you want to handle
        return ResponseEntity.status(...).body(...your response pojo...).build();
    }

}