if (getRegisteredBeans() != null) {
  BeanBuilder builder = getRegisteredBeans().get(name);
  if (builder instanceof ManagedBeanBuilder) {
    builder = new MyManagedBeanBuilder(builder.getManagedBeanInfo());
  }
  return builder;
}
return null;