public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handle(final DataIntegrityViolationException e, final WebRequest request) {

        final String requestPath = getRequestUri(request);

        return ResponseEntity.ok().body(requestPath);
    }

    protected String getRequestUri(final WebRequest request) {
        return ((ServletWebRequest) request).getRequest().getRequestURI();
    }
}