public class Super
{
    public Super (Super other)
    {
        //copy stuff from other to this
    }
}

public class Child extends Super
{
    public Child (Super other)
    {
        super(other);
        //continue constructor
    }

}