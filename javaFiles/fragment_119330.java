private class StreamOpener<T1, T2>
{
    T1 v1;

    StreamOpener(String fileName, Class<T1> t1Class, Class<T2> t2Class)
    {
        try
        {
            Constructor<T2> t2Constructor = t2Class.getConstructor(String.class);
            T2 v2 = t2Constructor.newInstance(fileName);
            Constructor<T1> t1Constructor = t1Class.getConstructor(t2Class);
            v1 = constructor.newInstance(v2);
        }
        catch (NoSuchMethodException|SecurityException|InstantiationException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e) // yuck
        {
           System.err.println("Reflection error, fire your programmer");
           System.exit(-1);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File " + fileName + " not found.  Exiting");
            System.exit(-1);
        }
        catch (Exception e)
        {
            System.err.println("Error on file " + fileName + "  Exiting");
            System.exit(-1);
        }
    }
}