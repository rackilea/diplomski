public abstract class Event<T, V>
{
    public abstract V doEventStuff(T args);
}

public class A extends Event<String, String>
{
    @Override public String doEventStuff(String str)
    {
        ...
    }
}