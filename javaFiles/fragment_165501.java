//start your while loop here
while (true)
{
    System.out.println("Would you like to find the Fibonacci number of another number?");
    String answer = in.next();
    if (answer.equalsIgnoreCase("Y"));
    {
        System.out.println("What number would you like to find the Fibonacci number for?");
        x = in.nextInt();
        System.out.println("The Fibonacci number for " + x + " is " + calcFibNum(x));
    }
    else 
    {
      System.out.println("Thanks for playing");
      break; // ends the while loop.
    }
}