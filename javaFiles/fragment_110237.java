public interface A<T extends A<T>>
{
    public default String write()
    {
        new JsonSerializer<T>();
    }
}

public class AX implements A<AX>
{
}