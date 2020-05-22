public abstract class SqlWorkClass<I extends Input>
{
    public abstract void updateDatabaseInfo(I input)
        throws ClassNotFoundException;
}
public abstract class Input {}

public class DatabaseInsertClass
    extends SqlWorkClass<InsertInput>
{
    @Override
    public void updateDatabaseInfo(InsertInput input)
        throws ClassNotFoundException
    {
        String param1 = input.newUserName;
        String param2 = input.newBalance;
    }
}
public abstract class InsertInput
    extends Input
{
    public final String newUserName, newBalance;

    public InsertInput(String newUserName, String newBalance)
    {
        this.newUserName = newUserName;
        this.newBalance = newBalance;
    }
}