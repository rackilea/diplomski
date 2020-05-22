public class ConcreteHandler implements ObjectHandler<ConcreteObject>
{
    @Override
    public void handle(ConcreteObject object) // <-- now this works
    {
        // ...
    }
}