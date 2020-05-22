public bankAcct findAcct()
{
    bankAcct myBankAcct = null;
    System.out.println("Greetings, please enter your account number: ");
    int acctNum = scannerObject.nextInt();
    //make sure you use myAcct.length to ensure you don't get an "ArrayOutOfBoundsIndex" error.
    for(count = 0; count < myAcct.length; count++){
        myBankAcct = myAcct[count];
        if(myBankAcct.getAcctNum() == acctNum){
            return myBankAcct;
        }
    }
    return myBankAcct;
 }

public void seeBal()
{
    bankAcct lfound = findAcct();
    if (lfound == null)
    {
        System.out.println("Error!");
    }else{
        lfound.dispBal();
    }
}