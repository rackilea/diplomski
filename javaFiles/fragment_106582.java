class MyClass<T extends Number & Comparable>
{
    void use(T t)
    {
        String s = null;
        t.compareTo(s); // Works, but will cause a runtime error
    }
}