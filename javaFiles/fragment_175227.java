for(PropertyDescriptor propertyDescriptor : 
    Introspector.getBeanInfo(yourClass).getPropertyDescriptors()){

    // propertyEditor.getReadMethod() exposes the getter
    // btw, this may be null if you have a write-only property
    System.out.println(propertyDescriptor.getReadMethod());
}