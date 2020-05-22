@RestController
public class APIExceptionHandler extends AbstractErrorController {
    private static final String ERROR_PATH = "/error";
    private final ErrorAttributes errorAttributes;

    @Autowired
    public APIExceptionHandler(ErrorAttributes errorAttributes) {
        super(errorAttributes);
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(path = ERROR_PATH)
    public ResponseEntity<?> handleError(HttpServletRequest request) {
        HttpStatus status = getStatus(request);

        Map<String, Object> errors = getErrorAttributes(request, false);
        getApiException(request).ifPresent(apiError -> {
            errors.put("message" , apiError.message());
            errors.put("code", apiError.code());
        });
        // If you don't want to expose exception!
        errors.remove("exception");


        return ResponseEntity.status(status).body(errors);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    private Optional<APIException> getApiException(HttpServletRequest request) {
        RequestAttributes attributes = new ServletRequestAttributes(request);
        Throwable throwable = errorAttributes.getError(attributes);
        if (throwable instanceof APIException) {
            APIException exception = (APIException) throwable;
            return Optional.of(exception);
        }

        return Optional.empty();
    }
}