public static void copyBeanProperties(final Object beanA, final Object beanB){
    try{
        @SuppressWarnings("unchecked") // this should be safe
        final Map<String, Object> beanAProps = PropertyUtils.describe(beanA);
        @SuppressWarnings("unchecked") // this should be safe
        final Map<String, Object> beanBProps = PropertyUtils.describe(beanB);

        if(!beanAProps.keySet().containsAll(beanBProps.keySet())){
            throw new IllegalArgumentException("Incompatible types: "
                + beanA + ", " + beanB);
        }
        for(final Entry<String, Object> entryA : beanAProps.entrySet()){
            if(beanBProps.get(entryA.getKey()) == null){
                PropertyUtils.setMappedProperty(beanB, entryA.getKey(),
                    entryA.getValue());
            }
        }
    } catch(final IllegalAccessException e){
        throw new IllegalStateException(e);
    } catch(final InvocationTargetException e){
        throw new IllegalStateException(e);
    } catch(final NoSuchMethodException e){
        throw new IllegalStateException(e);
    }
}