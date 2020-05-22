public class CheckingAccount
{
    private int _balance;
    private String _name;
    public CheckingAccount(String name, double initialBalance)
    {
        _name = name;
        _balance = (int)(initialBalance * 100);
    }
    ...
}