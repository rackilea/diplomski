/* Declare an interface for executing an operation */
public interface Command
{
    public void execute();
    public Command setNext();
    public Boolean hasNext();
}
/* Abstract class providing compose-ability and chaining behavior for its children.
*/
public abstract class BaseCommand implements Command
{
    private Command next;

    public Boolean hasNext()
    {
        return next != null;
    }
    public Command setNext(Command nextC)
    {
        next = nextC;
        return nextC;
    }
    public void execute(){
        executeImpl();
        if(hasNext()) next.execute();
    }

    public abstract void executeImpl();
}