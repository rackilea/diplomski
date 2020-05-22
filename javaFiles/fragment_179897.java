Object around(Field field, Object obj, Object value) :
    within(com.google.gson..*) &&
    call(public void Field.set(Object, Object)) &&
    target(field) &&
    args(obj, value)
{
    Object result = null;
    System.out.println(thisJoinPoint);
    System.out.println("  " + field + " -> " + field.getAnnotation(Annotation.class));
    System.out.println("  " + obj);
    System.out.println("  " + value);
    try {
        if (field.getAnnotation(Annotation.class) != null && field.getType() == String.class)
            result = proceed(field, obj, "intercepted");
        else
            result = proceed(field, obj, value);
    } catch (RuntimeException ex) {
        throw ex;
    }
    return result;
}