public class BaseClass
{
    public int b = 0;

    public BaseClass()
    {
        b = 10;
    }
}

public class ClassA extends BaseClass
{
    public ClassA()
    {
        b = 20;
    }
}

public class ClassAA extends ClassA
{
    public ClassAA()
    {
        b = 22;
    }
}

public class ClassB extends BaseClass
{
    public ClassB()
    {
        b = 30;
    }
}

public class BaseFactory 
{
    public static BaseClass create(Class<? extends BaseClass> clazz)
    {
        try
        {
            return clazz.getConstructor().newInstance();
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}