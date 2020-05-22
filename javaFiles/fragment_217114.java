SomeObjectInterface get()
{
    if(_someObjectStateIsSet)
    {
        // Return a concrete implementation A
        return new ConcreteImplA();
    }
    else
    {
        // Return a concrete implementation B
        return new ConcreteImplB();
    }
}