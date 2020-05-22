BigInteger fact= BigInteger.ONE;
    int factorialNo = 10;

    for (int i = 2; i <= factorialNo; i++){
      fact = fact.multiply(new BigInteger(String.valueOf(i)));
    }

    System.out.println("The factorial of " + factorialNo +
                                " (or " + factorialNo + "!) is: " + fact);
   final int digits = fact.toString().length();

   BigInteger number = new BigInteger(fact.toString());
   BigInteger reminder;
   BigInteger sum = BigInteger.ZERO;
   BigInteger ten = new BigInteger(String.valueOf(10));

   while(number.compareTo(BigInteger.ONE)>=0)
     {
     reminder=number.mod(ten);
     sum=sum.add(reminder);
     number=number.divide(ten);
     }

     System.out.println("The total sum of all the " + digits
                     + " idividual digits from the answer of the factorial of "
                     + factorialNo + " is: " + sum