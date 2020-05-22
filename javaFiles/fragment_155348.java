class Test
{
    static void Foo()
    {
        synchronized(Test.class)
        {
            ...
        }
    }

    void Bar()
    {
        synchronized(this)
        {
            ...
        }
    }
}