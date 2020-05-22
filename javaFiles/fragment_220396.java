private int noOfWithdrawals = 0;
private int tresholdOfWithdrawals = 5; //Change this according to your requirement

public void withdraw(double amount)
{
    if(noOfWithdrawals <= tresholdOfWithdrawals) {
       balance = balance - amount;
       noOfWithdrawals++;
    }
    else {
       balance = balance - amount - feeCharge;
    }
}