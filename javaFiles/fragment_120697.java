public interface Command
{
    void execute(Object parameter);
}

public class LeafCommand implements Command
{
    public void execute(Object parameter)
    {  
        // do something for a leaf
    }
}

public class CompositeCommand implements Command
{
    private List<Command> commands;

    void execute(Object parameter)
    {
        for (Command child : commands) 
        { 
           child.execute(parameter);
        }
    }

}