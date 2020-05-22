try {
    BeanInfo beanInfo = Introspector.getBeanInfo(props, Object.class);

    for (PropertyDescriptor prop : beanInfo.getPropertyDescriptors()) {
        if (klazz.isAssignableFrom(prop.getPropertyType())) {
            elementsOfType.add(klazz.cast(prop.getReadMethod().invoke(this)));
        }
    }
} catch (IntrospectionException | ReflectiveOperationException e) {
    throw new RuntimeException(e);
}