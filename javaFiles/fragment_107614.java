import java.util.Map;

abstract class A<T>
{
    protected final Class<T> typeOfX;

    public A(Class<T> typeOfX)
    {
        this.typeOfX = typeOfX;
    }

    public abstract void load(T x);
}

class AnyA<S> extends A<S>
{
    private final Map<String, A<? extends S>> map;

    public AnyA(Class<S> superTypeOfX,
        Map<String, A<? extends S>> map)
    {
        super(superTypeOfX);
        this.map = map;
    }

    @Override
    public void load(S s)
    {
        for (A<? extends S> a : map.values())
        {
            if (a.typeOfX.isAssignableFrom(s.getClass()))
            {
                callLoad(a, s);
            }
        }
    }

    private static <S, T extends S> T cast(A<T> a, S s)
    {
        T t = a.typeOfX.cast(s);
        return t;
    }

    private static <T, S extends T> void callLoad(A<S> a, T s)
    {
        a.load(cast(a, s));        
    }
}