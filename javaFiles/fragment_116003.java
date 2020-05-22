String[] getObjectsPublicMethods(Object o)
{
    Class clazz = o.getClass();
    Method[] methods = clazz.getDeclaredMethods();
    String[] result = new String[methods.length];
    for (int i=0; i<methods.length; ++i)
    {
        try
        {
            result[i] = (String) methods[i].invoke(o, new Object[] {})
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e)
        {

        }
    }
    return result;        
}