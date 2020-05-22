public static int enterNumGadgets(){   

int numOfGadgetsIn = 0;

try{
    System.out.println("");
    System.out.println("Please enter the number of items you wish to insure.");
    numOfGadgetsIn = EasyScanner.nextInt();
}
catch(InputMismatchException exception){

    System.out.println("You must enter a number.");
    EasyScanner.nextLine(); //consume new line left over
    numOfGadgetsIn = enterNumGadgets(); //call the method again

}
return numOfGadgetsIn;