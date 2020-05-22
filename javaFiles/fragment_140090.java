class Trader {

  //This field stores the trader's name
  private String traderName;

  //This field stores the trader's current balance
  private double currentBalance;

  //A constructor to create a Trader
  public Trader(String traderName) {
    this.traderName = traderName;
  }

  //This method gets returns the trader's name
  public String getName() {
    return traderName;
  }

  //This method set's the trader's name
  public void setName(String traderName) {
    this.traderName = traderName;
  }

  //This method decreases the trader's balance
  public void withdraw(double withdrawAmount) {
    this.currentBalance = (currentBalance - withdrawAmount);
  }

  //This method increases the trader's balance
  public void deposit(double depositAmount) {
    this.currentBalance = (currentBalance + depositAmount);
  }

  //This method returns the trader's current balance
  public double getBalance() {
    return currentBalance;
  }
}

public class TradingService{

    public static void main(String[] args)
    {

      Trader t = new Trader("test");
      t.deposit(10);
      System.out.print(t.getBalance());

    }
}