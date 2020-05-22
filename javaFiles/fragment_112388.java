public static void main(String[] args) {
    int numberofDays;//these two lines define variables
    int sharePoints;

    Scanner keyboard = new Scanner(System.in);//activating scanner
    System.out.print("Number of days in the period: ");//asking question

    numberofDays = keyboard.nextInt();//obtaining input by defining a variable as a keyboard input

    System.out.print("Share points on the first day: ");//asking another question
    sharePoints = keyboard.nextInt();//obtaining input by defining a variable as a keyboard input

    numberofDays = validator(numberofDays,keyboard); // Validates Keyboard input

    //above two lines print day and share points, as well as the first line of text (as it does not change)
    outPutTablePrinter(numberofDays,sharePoints);

}

private static void outPutTablePrinter(int numberOfDays,int sharePoints){
    System.out.println("Day " + " Share Points");
    System.out.println(1 + "    " + sharePoints);
    for (int i = 2; i <= numberOfDays; i++) {
        if (numberOfDays % 2 == 0)
            if (i <= numberOfDays / 2) {
                sharePoints = sharePoints + 50;
                System.out.println(i + "    " + sharePoints);
            } else {
                sharePoints = sharePoints - 25;
                System.out.println(i + "    " + sharePoints);
            } else {
            if (i <= numberOfDays / 2 + 1) {
                sharePoints = sharePoints + 50;
                System.out.println(i + "    " + sharePoints);
            } else {
                sharePoints = sharePoints - 25;
                System.out.println(i + "    " + sharePoints);
                // above nested if else statements essentially calculate and concatenate the variables to obtain an answer that is then printed and repeated until the number of days is reached (starting from day two)
            }
        }
    }
}

private static int validator(int numberOfDays,Scanner keyboard){
    while (numberOfDays < 10 || numberOfDays > 20)//while loop makes sure the conditions stay true
    {
        System.out.println("The number of days doesn’t meet the required criteria, enter it again");
        System.out.print("Number of days in the period: ");
        numberOfDays = keyboard.nextInt();
    }
    return numberOfDays;
}