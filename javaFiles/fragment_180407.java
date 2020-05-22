public int findAcct()
{
    int lnum = -1;
    System.out.println("Greetings, please enter your account number: ");
    //you get the users acct #
    lnum = scannerObject.nextInt();
    for(count = 0; count < max; count++){ //here you iterate, but you never "find" the account
        if (count == lnum)
            return count; //then you return the "count" rather than the account itself.
            }
    return lnum;
    }