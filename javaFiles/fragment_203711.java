public <T> T executeInTemplate(Map<String, String> headers, Callable<T> task) {
    CustomHttpInvokerRequestExecutor executor = (CustomHttpInvokerRequestExecutor) factoryBean.getHttpInvokerRequestExecutor();
    executor.setHeaders(headers);

    try {
        return task.call();
    } catch (Exception e) {
        // it is better to log this exception by your preferred logger (log4j, logback
        // etc.)
        e.printStackTrace();
    }

    return null;
}