public void runMenu() {
    int x = 1;
    Scanner Option = new Scanner (System.in);
    int Choice = 0; 
    boolean isValidChoice = false;
    do{  
       isValidChoice = false;
       Choice = 0; 
       System.out.println("Choose Option");
       System.out.println("");
       System.out.println("1: Create Account");
       System.out.println("2: Check Account");
       System.out.println("3: Take Action");
       System.out.println("4: Exit");
       System.out.println("Please choose");
       if(Option.hasNextInt()){
           Choice= Option.nextInt(); 
           isValidChoice = true;
       }
       switch (Choice)
       {
           case 1:
               CreateAccount();
               break; 
           case 2: 
               selectAccount();
               break;
           case 3:
               Menu();
               int choice = UserInput();
               performAction(choice);
               break;
           case 4:
               System.out.println("Thanks for using the application"); 
               System.exit(0);
           default:
                isValidChoice = false;    //if invalid choice, then set flag to loop
                System.out.println("Invalid Entry");
       }
    } while (!isValidChoice);
}