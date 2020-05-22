import java.lang.reflect.*;

public class Test
{
    public static void main(String[] args)
    {
        for (Field field : Inner.class.getDeclaredFields())
        {
            System.out.println(field.getName() + ": " + field.isSynthetic());
        }
    }

    class Inner
    {
    }
}