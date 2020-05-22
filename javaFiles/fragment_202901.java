/* Method to deposit money into the account. If more than £500 is desposited
in a month, £10 is rewarded to account balance */    
@Override
public void deposit (double amount)
{
    balance += amount;

    if (amount>=500)
    {
        balance += 10;     
    }
}