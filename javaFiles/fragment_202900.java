@Override
public void withdraw (double amount) 
{        
    double newBalance = balance - amount;

    if(newBalance < -200)
    {
        JOptionPane.showMessageDialog(frame,"Your account balance cannot fall below -£200");
        return; // Don't do withdraw
    }

    balance = newBalance; 
    numOfWithdrawls++;
}

/* Method to deposit money into the account. If more than £500 is desposited
in a month, £10 is rewarded to account balance */    
@Override
public void deposit (double amount)
{
    double newBalance = balance + amount;

    if (amount<500)
    {
        balance = newBalance;     
    }
    else{
        balance = newBalance + 10; 
    }
}