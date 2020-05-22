public void test()
{
    StaticVar<Integer> s1 = new StaticVar<Integer>(){};

    StaticVar<Long> s2 = new StaticVar<Long>(){};

    Integer v1 = s1.get();
    System.out.println(v1);
    s1.set( v1==null? 1 : v1+1 );

    Long v2 = s2.get();
    System.out.println(v2);
    s2.set( v2==null? 1 : v2*2 );
}

public abstract class StaticVar<V>
{
    public V get()
    {
        return (V)class2value.get(this.getClass());
    }

    public void set(V value)
    {
        class2value.put(this.getClass(), value);
    }

    static WeakHashMap<Class,Object> class2value = new WeakHashMap<>();
}