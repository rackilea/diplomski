public class MyClass
{
    private String string;
    private int int1;
    private int int2;
    private int int3;

    public MyClass()
    {
    }

    public MyClass(String string, int int1, int int2, int int3)
    {
        this.string = string;
        this.int1 = int1;
        this.int2 = int2;
        this.int3 = int3;
    }

    public String getString()
    {
        return string;
    }

    public MyClass setString(String string)
    {
        this.string = string;
        return this;
    }

    public int getInt1()
    { 
        return int1;
    }
    ...
}