String redo;
do{
    System.out.println("Would you like to do another calculation?");
    redo = input.nextLine();

    if(redo.equals("yes"))
        theMath();
    else if(redo.equals("no"))
        System.out.println("Thanks for calculating with me! It certainly was fun!");
    else
        System.out.println("Please enter 'yes' or 'no' only.");
        String yesNo = input.nextLine();
    if(yesNo.equals("yes"))
            theMath();
    else
        System.out.println("Thanks for calculating with me! It certainly was fun!");
}while(redo.equals("yes"))