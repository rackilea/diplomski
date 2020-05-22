class MyClass<T extends Number & Comparable>
{
    void use(T t)
    {
        String s = "Laziness";
        t.compareTo(s); // Works, but will cause a runtime error
    }
}


public class MyClassTest
{
    public static void main(String[] args)
    {
        MyClass<Integer> m = new MyClass<Integer>();
        Integer integer = new Integer(42);
        m.use(integer);
    }
}