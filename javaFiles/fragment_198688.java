@ControllerAdvice
public class YourControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleBusinessLayerException(
            Exception exception) {
        Map<String, String> body = Map.of("errorMessage", exception.getMessage());
        return ResponseEntity.badRequest().body(body);
    }

}