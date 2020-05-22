public class A
{
    public int allowedMethod() { ... }
    public int forbiddenMethod() { ... }
}

public class B extends A
{
    public int forbiddenMethod()
    {
        throw new UnsupportedOperationException("Sorry, not allowed.");
    }
}