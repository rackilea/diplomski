public Object build(InjectionProvider injectionProvider,
    FacesContext context) {
  Object bean = newBeanInstance();
  injectResources(bean, injectionProvider);
  buildBean(bean, context);
  if (bean instanceof SomeInterface == false) {
    invokePostConstruct(bean, injectionProvider);
  }
  return bean;
}