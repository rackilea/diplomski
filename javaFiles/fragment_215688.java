public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a dollar amount:");
    String amountInString;

    while ((amountInString = input.nextLine()) != null && isValidAmount(amountInString)) {
      // remove the  System.out.print("Enter a dollar amount:"); from the while loop
      double amount = Double.parseDouble(amountInString);
      convert(amount);
    }
  }