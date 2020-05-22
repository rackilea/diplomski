public static void copyBeanProperties(
    final Object beanA, final Object beanB){

    if(beanA.getClass() != beanB.getClass()){
        // actually, this may be a problem, because beanB may be a
        // cglib-created subclass
        throw new IllegalArgumentException();
    }
    try{
        for( final PropertyDescriptor pd :
            Introspector
              .getBeanInfo(beanB.getClass(), Object.class)
              .getPropertyDescriptors()){
            if(pd.getReadMethod().invoke(beanB)==null){
                pd.getWriteMethod().invoke(beanB,
                    pd.getReadMethod().invoke(beanA)
                );
            }
        }
    } catch(IntrospectionException e){
        throw new IllegalStateException(e);
    } catch(IllegalAccessException e){
        throw new IllegalStateException(e);
    } catch(InvocationTargetException e){
        throw new IllegalStateException(e);
    }
}