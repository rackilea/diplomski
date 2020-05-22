static Map<Integer, Object> locks = new ConcurrentHashMap<>();

public static void main(String[] args)
{
    int i1 = 1;
    int i2 = 2;

    foo(i1);
    foo(i1);
    foo(i2);
}

public static void foo(int o)
{
    synchronized (locks.computeIfAbsent(o, k -> new Object()))
    {
        // computation
    }
}