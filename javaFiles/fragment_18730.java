class Test<A,B> { }
class Test<A> { }

public class Program
{
    public static void Main()
    {
        var one = new Test<string>();
        var two = new Test<string, int>();
    }
}