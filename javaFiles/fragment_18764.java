public class BankAccount {

  public static void main(String[] args) { 

      BankAccount account = new BankAccount();

      account.deposit(1000); 
      account.deposit(2000);
      System.out.println("Balance: " + account.getBalance()); 
      account.deposit(3000); 
      account.deposit(4000);
      System.out.println("Balance: " + account.getBalance());
  }

  private int currentBalance = 0;

  private int getBalance() {
      return this.currentBalance;
  }

  public void deposit(int depositAmount) {
      this.currentBalance = this.currentBalance + depositAmount;
  } 
}