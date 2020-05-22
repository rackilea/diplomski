BeanInfo beanInfo = Introspector.getBeanInfo(MappingMemberWithGetterOrSetter.class, Object.class);
PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
    String propertyName = propertyDescriptor.getName();
    Method getter = propertyDescriptor.getReadMethod();
    Method setter = propertyDescriptor.getWriteMethod();
    Field field = MappingMemberWithGetterOrSetter.class
                .getDeclaredField(propertyName);
    System.out.println("Property " + propertyName + " field:  " + field);
    System.out.println("Getter " + getter);
    System.out.println("Setter " + setter);
}