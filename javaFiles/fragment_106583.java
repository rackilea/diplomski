class MyClass<T extends Number & Comparable<T>>
{
    void use(T t)
    {
        String s = null;
        t.compareTo(s); // Compile-time error
    }
}