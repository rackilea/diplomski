PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(leftBean);
if (descriptors != null) {
  for (PropertyDescriptor descriptor : descriptors) {
    try {
      String propertyName = descriptor.getName();
      Object val = PropertyUtils.getProperty(leftBean, name);
      if (val != null) {
        PropertyUtils.setProperty(rightBean, name, val);
      }
    } catch (Exception ignore) {
      // not interested in what we can't read or write
    }
  }
}