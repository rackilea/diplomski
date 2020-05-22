@Override
public String toString() 
{
    return "[" + getAccountNumber() + "], " +
        super.toString() + ", " +
        owner + ", " +
        currentBalance + ", " +
        interestRate;
}