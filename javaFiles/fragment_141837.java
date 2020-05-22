class PromptForMoney {
  private BigDecimal amount;
  private String currency;

  public void prompt(Scanner in) {
    System.out.print("Enter an amount of money and currency to convert: ");
    while (in.hasNextLine()) {
      try {
        processLine(in.nextLine());
        return;
      } catch (InputMismatchException | NoSuchElementException e) {
        // we use the exception message to describe the problem to the user
        // if Scanner generates exceptions with unclear messages you can
        // catch them in processLine() and throw your own with a better message.
        System.out.print("Invalid input - " + e.getMessage() + ": ");
      }
    }
    throw new NoSuchElementException(
        "No more input to read, but a valid amount or currency was not entered.");
  }

  private void processLine(String line) {
    Scanner lineScanner = new Scanner(line);
    if (amount == null) {
      // this line will raise an exception if the line is empty
      // or if it doesn't start with numerical token
      amount = lineScanner.nextBigDecimal();
    }
    if (currency == null) {
      // this line will raise an exception if the user didn't specify a currency
      String c = lineScanner.next();
      if (isValidCurrency(c)) {
        currency = c;
      } else {
        throw new InputMismatchException(c + " is not a valid currency");
      }
    }
    // if we get this far without raising an exception we've read a valid
    // amount and currency from the user.
  }
}