public static void EasyAddition(){

    Scanner in = new Scanner(System.in);
    System.out.print("Enter the amount of problems you wish to do: ");
    int amountEA = in.nextInt();
    int correct = EasyAdder(amountEA, correct);
    System.out.println(correct);
    int incorrect = amountEA - correct;
    System.out.println("You have gotten: " +correct+ " correct!");
    System.out.println("You have gotten: " +incorrect+ " incorrect.");
    }