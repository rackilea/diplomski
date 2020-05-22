public class MyAppException extends Exception
{
    private String errorCode;
    public MyAppException(String errorCode, String message)
    {
        super(message);
        this.errorCode = errorCode;
    }
    // errorCode getter & setter
}