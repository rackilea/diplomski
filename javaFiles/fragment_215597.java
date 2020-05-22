System.out.println("Please Enter Your Bank Pin.");
Scanner userInput = new Scanner (System.in);
int number;
int password = 7123;
int amount = 4000;
int option;

number = userInput.nextInt();

if (number == password) {
    System.out.println("Pin Accepted");
    System.out.println("You Have Now Entered Harry's Bank!");
    System.out.println("Press The Number Of The Option You Would Like.");
    System.out.println("1.Withdraw Money.");
    System.out.println("2.Put In Money");
    System.out.println("3.Exit Bank");
    Scanner Options = new Scanner (System.in);
    option = userInput.nextInt();
    while (option != 1 || option != 2 || option != 3) {
        System.out.println("You didn't enter a valid number. Try again");
        option = userInput.nextInt();
    }
    if (option == 1){
        Option_1 Optionone = new Option_1();
        Optionone.Withdraw();
    }
    else if (option == 2){
        Option_2 Optiontwo = new Option_2();
        Optiontwo.Deposit();
    }
    else if (option == 3){
        Option_3 Optionthree = new Option_3();
        Optionthree.Exit();
    }
}
else
    System.out.println("The Pin You Entered Was Wrong");
}