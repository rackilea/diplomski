String answer = "Y";
//start your while loop here
while (answer.equals("Y")) {
    System.out.println("Would you like to find the Fibonacci number of another number?");
    answer = in.next(); //declare your variable answer outside the loop so you  can use it in the evaluation of how many times to do the loop.
    if (answer.equalsIgnoreCase("Y"));
    {
        System.out.println("What number would you like to find the Fibonacci number for?");
        x = in.nextInt();
        System.out.println("The Fibonacci number for " + x + " is " + calcFibNum(x));
    }
    else 
    {
        System.out.println("Thanks for playing");
        // no need to break out.
    }
}