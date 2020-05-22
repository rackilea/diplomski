if (e.getSource() == withdraw) {
   try
   {
     if(getAmount(tf4) > acc1.getBalance())
     {
         throw InsufficientFundsException("Insufficient Funds");
     }
     acc1.withdraw(getAmount(tf4));
     refreshFields();
     status.setText("Withdrawal Processed");
   }
   catch(InsufficientFundsException ex)
   {
      //rethrow some unchecked exception like IllegalArgumentException
      //or your own checked exception like EmptyFieldException 
      throw new EmptyFieldException("some message", ex);

      //or add the exception message and trace to status.
      status.setText(ex.getMessage() + "withdraw");
   }
   catch(EmptyFieldException ex)
   {
      status.setText(ex.getMessage() + "withdraw");
   }
   catch(NumberFormatException ex)
   {
      status.setText(ex.getMessage() + "withdraw");
   }
   catch(NegativeAmountException ex)
   {
     status.setText(ex.getMessage() + "withdraw");
   }
}