private String calculateinterest() {
        // TODO Auto-generated method stub

         String amount = principalAmount.getText().toString();
         String rate = interestRate.getText().toString();

         if (amount.trim().equlas("") || rate.trim().equals(""))
          Toast.makeText(getApplicationContext(), "Please enter the values", Toast.Length_SHORT).show();

         else
         {

             pAmount=Float.parseFloat(amount);
             iRate = Float.parseFloat(rate);



             totalAmount=(pAmount*(iRate/100)*years);
             String output = "( " + totalAmount +" we did it!!) ";
             return output;

         }
    }