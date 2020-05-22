public abstract class Account
{
    public int applyInterest()
    {
        return 10 * getInterestRate();
    }
    abstract protected int getInterestRate();
}