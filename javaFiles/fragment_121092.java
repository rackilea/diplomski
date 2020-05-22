public Object myMethod(Object myObject, String thePropertyName, Object someValue) 
{
    try
    {
        myObject.getClass().getField(thePropertyName).set(myObject, someValue);
    } catch (NoSuchFieldException noFieldException) {
        throw new RuntimeException(noFieldException);
    } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
    }
}