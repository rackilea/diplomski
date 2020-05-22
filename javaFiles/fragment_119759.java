private static Class<?> getPrimitiveClass(final Class<?> wrapperClass){
    try{
        final Field field = wrapperClass.getDeclaredField("TYPE");
        final int modifiers = field.getModifiers();
        if(Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)
            && Modifier.isFinal(modifiers)
            && Class.class.equals(field.getType())){
            return (Class<?>) field.get(null);
        } else{
            throw new IllegalArgumentException("This is not a wrapper class: "
                + wrapperClass);
        }
    } catch(final NoSuchFieldException e){
        throw new IllegalArgumentException("This is not a wrapper class:"
            + wrapperClass + ", field TYPE doesn't exists.", e);
    } catch(final IllegalAccessException e){
        throw new IllegalArgumentException("This is not a wrapper class:"
            + wrapperClass + ", field TYPE can't be accessed.", e);
    }
}

public static void main(final String[] args){
    final List<Class<?>> wrappers =
        Arrays.<Class<?>> asList(
            Byte.class, Long.class, Integer.class,
            Short.class, Boolean.class, Double.class
            // etc.
        );
    for(final Class<?> clazz : wrappers){
        System.out.println("Wrapper type: " + clazz.getName()
            + ", primitive type: "
            + getPrimitiveClass(clazz).getCanonicalName());
    }

}