public class Bank 
{   
    ArrayList<Account> accounts = new ArrayList<Account>();
    String name;

    public Bank(String name)
    {
        this.name = name; 
    }
    public void addAccount(Account acct)
    {
        accounts.add(acct);
    }
    public void addInterest()
    {
        for (Account acct : accounts)
            acct.addInterest();
    }
}