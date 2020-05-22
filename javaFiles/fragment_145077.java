public class Member { 

  private String name;
  private String alias;
  private int balance;


  public Member(String fullName, String nickname)
  {
      this.name = fullName;
      this.alias = nickname;
      this.balance = 0;
  }
  public void setBalance(int account)
  {
      if(account > 0)
      {
          balance = balance + account;
      }
      else
      {
          System.out.println("You have not entered a valid number");
      }
  }

  public String getName()
  {
      return name;
  }
  public String getAlias()
  {
      return alias;
  }

  public int getBalance()
  {
      return balance;
  }

  @Override
  public String toString() {
    return this.name + "\t" + this.balance;
  }

}