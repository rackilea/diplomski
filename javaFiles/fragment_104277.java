public class ContextAwareExecutorDecorator implements Executor, TaskExecutor {

    private final Executor executor;

    public ContextAwareExecutorDecorator( Executor executor) {
        this.executor = executor;
    }

    @Override
    public void execute( Runnable command) {
        Runnable ctxAwareCommand = decorateContextAware(command);
        executor.execute(ctxAwareCommand);
    }

    private Runnable decorateContextAware( Runnable command) {
        RequestAttributes originalRequestContext = RequestContextHolder.currentRequestAttributes();

        if (originalRequestContext != null) {
            HttpServletRequest request = ((ServletRequestAttributes) originalRequestContext).getRequest();
            copyRequestToMDC(request);
        }

        final Map<String, String> originalContextCopy = MDC.getCopyOfContextMap();
        return () -> {
            try {
                if (originalRequestContext != null) {
                    RequestContextHolder.setRequestAttributes(originalRequestContext);
                }
                MDC.setContextMap(originalContextCopy);
                command.run();
            } finally {
                MDC.clear();
                RequestContextHolder.resetRequestAttributes();
            }
        };
    }

    private void copyRequestToMDC( HttpServletRequest request) {
        if (request != null) {
            MDC.put("requestURI", request.getRequestURI());
            // Set other required attributes
        }
    }
}