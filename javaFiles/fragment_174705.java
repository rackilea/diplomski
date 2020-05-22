public interface ReadAccountBalance
{
    float getBalance ();
}

public interface WriteAccountBalance
{
    void setBalance (float balance);
}

public class AccountBalanceBean implements ReadAccountBalance, WriteAccountBalance
{
    ...
}