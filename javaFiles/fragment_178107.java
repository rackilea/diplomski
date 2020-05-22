public class Executor
{

    public void executeCommand(Command command)
    {
        try
        {
            // Put any boilerplate code here (logging, auditing, etc.)
            command.execute();
        }
        catch (Exception ex)
        {
            // Put general error handling code here.  If you're just catching and rethrowing, consider not catching the Exception at this level.  If it's a checked exception, add a throws clause to the method.
            throw new CustomException();
        }
    }
}