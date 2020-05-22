public static void copyBeanProperties(final Object beanA, final Object beanB){

    final BeanWrapper wrapperA = new BeanWrapperImpl(beanA);
    final BeanWrapper wrapperB = new BeanWrapperImpl(beanB);

    try{
        for(final PropertyDescriptor descriptor : wrapperB
            .getPropertyDescriptors()){

            final String propertyName = descriptor.getName();
            if(wrapperB.getPropertyValue(propertyName) == null){
                wrapperB.setPropertyValue(propertyName,
                    wrapperA.getPropertyValue(propertyName));
            }
        }
    } catch(final /* unchecked */ InvalidPropertyException e){
        throw new IllegalArgumentException("Incompatible types: " + beanA
            + ", " + beanB, e);
    }
}