BeanInfo beanInfo = Introspector.getBeanInfo(beanClass, Object.class);
PropertyDescriptor descriptors[] = beanInfo.getPropertyDescriptors();
for (PropertyDescriptor d : descriptors) {
    final Type type = d.getReadMethod().getGenericReturnType();
    if (type instanceof ParameterizedType) {
        ParameterizedType pt = (ParameterizedType) type;
        System.out.println(d.getDisplayName());
        for (Type atp : pt.getActualTypeArguments()) {
            System.out.println("  " + atp);
        }
    }
}