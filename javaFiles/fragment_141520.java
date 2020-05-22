public class Foo
{
    private String name;
    private FooRuntime runtime;

    public int getRuntime()
    {
        return runtime.getValue();
    }
}

public class FooRuntime
{
    private int value;

    public FooRuntime(int runtime)
    {
        this.value = runtime;
    }

    public int getValue()
    {
        return value;
    }
}