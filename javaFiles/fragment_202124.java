int actNum = 0;
    if(account.hasNextInt()) {
        //Get the account number 
        actNum = account.nextInt();
    }
    else
    {
        return;//Terminate program
    }