@ControllerAdvice
public class DefaultExceptionHandler {

    @Autowired
    private CPro cPro;

    private static final Logger LOG = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, HttpServletRequest request) throws IOException {

        DefaultExceptionHandler.LOG.error("Internal Server Exception", ex);

        String exceptionType = ex.getClass().getSimpleName();

        ErrorResponse response = new ErrorResponse();

        if (ex.getCause() != null) {
            response.addError(exceptionType, ex.getCause().getMessage(), cPro.getProName());
        } else {
            response.addError(exceptionType, ex.getMessage(), cPro.getProName());
        }

        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        if (outputFlashMap != null) {
            outputFlashMap.put("processingException", response);
        }

        return "redirect:/";
    }
}