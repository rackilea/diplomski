public class MyBaseClass
{
    public MyBaseClass ()
    {
        Console.WriteLine (this.ToString());
    }
}

public class MyDerivedClass : MyBaseClass
{
    string name="hello";

    public MyDerivedClass() : base()
    {
        Console.WriteLine (this.ToString());
    }

    public override string ToString()
    {
        return name;
    }
}