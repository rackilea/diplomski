class B { } 
class G<T extends B> 
{
    T get() { return null; }
}

public class Example
{
    public static void main(String[] args)
    {
        G<?> g = null;

        // This works, even though "G<?>" seemingly does not say 
        // anything about the type parameter:
        B b = g.get();
    }
}