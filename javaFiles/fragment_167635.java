@Override
protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName,   TargetSource targetSource) {
  if (beanClass != null && isInPackages(beansPackages, beanClass.getName()) &&   hasAspectAnnotation(beanClass)) {
    return super.getAdvicesAndAdvisorsForBean(beanClass, beanName, targetSource);
  } else {
    return DO_NOT_PROXY;
  }
}