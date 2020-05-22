public class QueueFullException extends Exception
{
    public void fullException(String message) 
    {
        super(message);
    }
}

public class QueueEmptyException extends Exception
{
    public void emptyException(String message) 
    {
         super(message);
    }
}