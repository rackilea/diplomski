public class Test
{
    public static void main(String[] args)
    {
        Object x = "I'm a string";
        foo(x);
    }

    public static void foo(String x)
    {
        System.out.println("foo(String)");
    }

    public static void foo(Object x)
    {
        System.out.println("foo(Object)");
    }
}