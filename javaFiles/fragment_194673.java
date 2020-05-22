public class SuperClass
{
    public SuperClass()
    {
        new SubClass();
    }
}

public class SubClass extends SuperClass
{
    public SubClass()
    {
        super();
    }
}