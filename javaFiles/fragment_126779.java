public class SavingsAccount extends Account {

  private SavingsAccount(String init_id, double init_balance)
  {
    super(init_id, validate(init_balance));
  }

  public static double validate(double init_balance) {
    if (init_balance < minimumSavings) {
        System.out.println("Message");
        throw new RuntimeException("Message"); // or handle this error
    }
    return init_balance;
  }
}