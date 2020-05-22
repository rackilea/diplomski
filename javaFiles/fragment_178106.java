public interface Command
{
    public void execute();
}

public class ActionOne implements Command
{
    public void execute()
    {
        // do actionOne...
    }
}

public class ActionTwo implements Command
{
    public void execute()
    {
        // do actionTwo...
    }
}

// etc. for more actions