public class GlobalExceptionHandlerTests {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler() {
        @Override
        protected String getRequestUri(final org.springframework.web.context.request.WebRequest request) {
            return "http://localhost.me";
        };
    };

    @Test
    void test() throws Exception {

        final ResponseEntity<Object> handled = handler.handle(new DataIntegrityViolationException(""),
                null);
        assertEquals("http://localhost.me", handled.getBody());
    }
}