public class Container
{
    public void Remove(Element e)
    {
        e.RemoveImplementation();
        RemoveImplementation();
    }

    // Not directly callable by client code, but callable
    // from Element class in the same package
    protected void RemoveImplementation()
    {
       // Mess with internals of this class here
    }
}


public class Element
{
    private Container container;

    public void Remove()
    {
       RemoveImplementation();
       container.RemoveImplementation();
    }

    // Not directly callable by client code, but callable
    // from Container class in the same package
    protected void RemoveImplementation()
    {
        // Mess with internals of this class here.
    }
}