public class GrandParent
{
    public void walk()
    {
        ...
    }
}

public class Parent
{
    public void walk()
    {
        ...
    }

    public void grandParentWalk()
    {
        super.walk();
    }
}

public class Child
{
    public void walk()
    {
        grandParentWalk();
    }
}