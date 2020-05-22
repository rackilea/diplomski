public void invokePostConstruct(Object bean, InjectionProvider injectionProvider) {
  try {
    injectionProvider.invokePostConstruct(bean);
  } catch (InjectionProviderException ipe) {
    String message = MessageUtils.getExceptionMessageString(
    MessageUtils.MANAGED_BEAN_INJECTION_ERROR_ID,
    beanInfo.getName());
    throw new ManagedBeanCreationException(message, ipe);
  }
}