public static void main(String[] args)  {
   Scanner console = new Scanner(System.in);
   double digit1;
   double digit2;
   double total;
   String operator = ""; 
   boolean repeatFlag = true;
   while(repeatFlag)   {
     System.out.print("Enter a valid operator(+, -, /, *): ");
     operator = console.next();
   if(!(operator.equals("+") || 
          operator.equals("-") || operator.equals("/") || operator.equals("*"))) 
     {
    repeatFlag=true;
    continue;
     }
        repeatFlag = false;
   }

   System.out.print("Enter 1st number: ");
   digit1 = console.nextDouble();
   System.out.print("Enter 2nd number: ");
   digit2 = console.nextDouble();

  if (operator.equals("-"))
  {
    total = digit1-digit2;
    System.out.println(+digit1+ "-" +digit2+ "=" +total);
  }
  else if (operator.equals("+"))
  {
    total = digit1+digit2;
    System.out.println(+digit1+ "+" +digit2+ "=" +total);
  }
  else if (operator.equals("*"))
  {
    total = digit1*digit2;
    System.out.println(+digit1+ "*" +digit2+ "=" +total);
  }
  else if (operator.equals("/"))
  {
    total = digit1/digit2;
    System.out.println(+digit1+ "/" +digit2+ "=" +total);
  }

 }