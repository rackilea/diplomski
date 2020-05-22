private ExceptionHandlerExceptionResolver createExceptionResolver() {
    ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
        @Override
        protected ServletInvocableHandlerMethod getExceptionHandlerMethod(
            HandlerMethod handlerMethod, Exception exception) {
            Method method = new ExceptionHandlerMethodResolver(
                    MyAppExceptionHandler.class).resolveMethod(exception);
            return new ServletInvocableHandlerMethod(
                new MyAppExceptionHandler(), method);
        }
    };
    exceptionResolver.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    exceptionResolver.afterPropertiesSet();
    return exceptionResolver;
}