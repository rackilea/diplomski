@Override
public Object convert(Object destination, Object source, Class<?> destinationClass,    Class<?> sourceClass) {
    if(source == null)
        return null;
    if(destinationClass != null){
        if(destinationClass.getSimpleName().equalsIgnoreCase("String")){
            return this.getString(source);
        }else if( destinationClass.isEnum()){

            return this.getEnum(destinationClass, source);

        }else{
            throw new MappingException(new StrBuilder("Converter ").append(this.getClass().getSimpleName())
                       .append(" was used incorrectly. Arguments were: ")
                       .append(destinationClass.getClass().getName())
                       .append(" and ")
                       .append(source).toString());
        }
    }
    return null;
}

private Object getString(Object object){
    String value = object.toString();
    return value;
}
private Object getEnum(Class<?> destinationClass, Object source){
    Object enumeration = null;

    Method [] ms = destinationClass.getMethods();
    for(Method m : ms){
        if(m.getName().equalsIgnoreCase("valueOf")){
            try {
                enumeration = m.invoke( destinationClass.getClass(), (String)source);
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return enumeration;
        }
    }
    return null;
}