static Account[] account = new Account[10];

public static void main(String[] args) 
{
    for ( int i=0; i<account.length; i++) 
    {
        account[i]=new Account();
    }
    account[0].owner = "Thomas";
    account[0].amount = 24325;
    System.out.println(getAmount(0));
}