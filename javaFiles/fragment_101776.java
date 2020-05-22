public class DatabaseException extends Exception implements IsSerializable
{
    private static final long serialVersionUID = -7935074533073743071L;

    public DatabaseException()
    {
        super();
    }

    public DatabaseException(String message)
    {
        super(message);
    }

    public DatabaseException(Exception e)
    {
        super(e);
    }
}