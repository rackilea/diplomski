public static Object runGetter(Field field, BaseValidationObject o)
{
    // MZ: Find the correct method
    for (Method method : o.getMethods())
    {
        if ((method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3)))
        {
            if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase()))
            {
                // MZ: Method found, run it
                try
                {
                    return method.invoke(o);
                }
                catch (IllegalAccessException e)
                {
                    Logger.fatal("Could not determine method: " + method.getName());
                }
                catch (InvocationTargetException e)
                {
                    Logger.fatal("Could not determine method: " + method.getName());
                }

            }
        }
    }


    return null;
}