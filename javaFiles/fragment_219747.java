String code = userInput.substring(userInput.length()-3,userInput.length());
    state = Currency.valueOf(code);
    system.out.print(state.name);


public enum Currency{
  SEK("Sweden"),
  GBP("British Pound");

  private String name;

  public Currency(String n) { this.name = n; }
  public String toString() { return this.name; }
}