@Override
public void configureHandlerExceptionResolvers(
            List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new CustomHandlerExceptionResolver());
        addDefaultHandlerExceptionResolvers(exceptionResolvers);
}