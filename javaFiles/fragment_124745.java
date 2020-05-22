/**
 * Template method to create a new InitBinderDataBinderFactory instance.
 * <p>The default implementation creates a ServletRequestDataBinderFactory.
 * This can be overridden for custom ServletRequestDataBinder subclasses.
 * @param binderMethods {@code @InitBinder} methods
 * @return the InitBinderDataBinderFactory instance to use
 * @throws Exception in case of invalid state or arguments
 */
protected InitBinderDataBinderFactory createDataBinderFactory(List<InvocableHandlerMethod> binderMethods)
        throws Exception {

    return new ServletRequestDataBinderFactory(binderMethods, getWebBindingInitializer());
}