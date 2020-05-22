public void withdraw (double balance)
{
  System.out.println("How much would you like to withdraw?");
  double amount = keyboard.nextDouble();  

  try
  {
   if(amount < balance)
   {
    balance = balance-amount;
    System.out.println("You have withdrawn "+amount+ " and your new balance is "+balance);
   }
  else
   throw new IncorrectWithdrawException();
  }
 catch(IncorrectWithdrawException e)
 {
    System.out.println(e.getMessage());
    withdraw(balance);// keeps calling the method for a loop if they keep entering incorrect amount
 }
 }