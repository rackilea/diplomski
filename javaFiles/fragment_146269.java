public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in);

    String SquareRoot;

    System.out.println("Type 'SquareRoot' - find the square root of (x)");
    SquareRoot = userInput.next();

    if (SquareRoot.equals("SquareRoot"))
    {
      // You shouldn't create a new Scanner
      // Scanner numInput = new Scanner(System.in);
      System.out.println("Enter a number - ");
      double sR;
      // Reuse the userInput Scanner
      sR = userInput.nextDouble();
      System.out.println("The square root of " + sR + " is " + Math.sqrt(sR));
    }

    // Be sure to close your Scanner when done
    userInput.close();
  }