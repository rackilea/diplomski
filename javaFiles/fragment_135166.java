public class ConsoleDispatcher implements Dispatcher
{
    public void dispatch(String message)
    {
        System.out.println(message);
    }
}