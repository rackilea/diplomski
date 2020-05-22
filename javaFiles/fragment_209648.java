public interface Interface {}

public class Test<T>
{
public void add(Class<? extends T> x)
{

}

public static void x()
{
    Test<Interface> t = new Test<Interface>();
    t.add(Implementation.class);
}

public static class Implementation implements Interface{}
}