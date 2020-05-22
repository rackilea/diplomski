public static void balance(int amount, double rate, int year){

  double yearlyInterestPaid ;
  double totalAmount = amount;


  System.out.println(amount + " :- " + " grows with the interest rate of " + rate);

  for (int i = 0; i <= year; i++ ){

    yearlyInterestPaid = totalAmount * rate;
    totalAmount += yearlyInterestPaid;
    System.out.println(i + "   " + totalAmount);
  }
}