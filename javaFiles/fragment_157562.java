BeanInfo jcomponentBeanInfo = Introspector.getBeanInfo(JComponent.class);

PropertyDescriptor[] propertyDescriptors = jcomponentBeanInfo.getPropertyDescriptors();
for (int i = 0; i < propertyDescriptors.length; i++) {
  PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
  if("rootPane".equals(propertyDescriptor.getName())){
    System.out.println("Found property rootPane");
    break;
  }
}