public class BankAccount {
  private final String owner;
  private final String id;
  private double currentBalance;

  public BankAccount(String owner, String id) {
    this(ownwer, id, 0);
  }

  public BankAccount(String owner, String id, double currentBalance) {
    this.owner = owner;
    ...