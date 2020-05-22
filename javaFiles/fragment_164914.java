public interface Command<R>
{
    public R execute();//parameter R is the type of object that will be returned as the result of the execution of this command
}

public abstract class BasicCommand<R> implements Command<R>
{
}

public interface CommandProcessor
{
    public <R> R process(Command<R> command);
}

public class BasicCommandProcessor implements CommandProcessor
{
    public <R> R processBasicCommand(BasicCommand<R> command)
    {
       return command.execute();
    }

    public <R> R process(Command<R> command)
    {
       return processBasicCommand((BasicCommand<R>)command);
    }
}