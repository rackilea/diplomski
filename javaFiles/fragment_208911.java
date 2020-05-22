class Accounts{
private String id;
    private double balance;
    private String name;
    private double withdraw;
    private double deposit;
    //parametric Constructor
    public Accounts(String id,String name, double balance,double withdraw,double deposit){
        setId(id);
        setName(name);
        setBalance(balance);
        setWithdraw(withdraw);
        setDeposit(deposit);
    }
   //Default Construcor:
   //Highly recommended having it because you have a parametric constructor
   public Accounts(){
    //...
   }

/*
Don't forget setters and Getter
........ 
*/

    @Override
    public String toString(){
        return "ID: "+getId()+"\n"
                +"Name: "+getName()+"\n"
                +"Balance: "+getBalance()+"\n"
                +"Withdraw: "+getWithdraw()+"\n"
                +"Deposit: "+getDeposit()+"\n";
    }
}