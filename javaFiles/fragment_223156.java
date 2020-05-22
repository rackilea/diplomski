public class Derived extends Super

{

    @Override
    void initialise()
    {
        System.out.println("Now you can't initialise field \"a\" anymore");
    }
    Derived()
    {

    }
    public static void main(String[] args)
    {
        Derived d = new Derived();

    }
}

class Super
{
    private int a;
    void initialise()
    {
        a = 10;
    }
    Super()
    {
        initialise();
    }
}