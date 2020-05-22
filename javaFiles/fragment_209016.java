private void F1()
{
    AtomicBoolean foo = new AtomicBoolean(false);
    List<String> result = F2(foo);

    if(foo.get())
    {
        // do something
    }
}

private List<String> F2(AtomicBoolean foo)
{
// Logic to set the result
    List<String> result = new ArrayList();

    if(condition)
    {
        foo.set(true);
    }

    return result;
}