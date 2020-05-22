do{
    System.out.println("Make a selection:\n");
    System.out.println("A: Enter a number for Group 1.");
    System.out.println("B: Enter a number for Group 2.");
    System.out.println("X: Exit and total the numbers for each group.\n");
    System.out.println("Select your option: ");
    answer = keyboard.next();

    if (answer.equalsIgnoreCase("A")){
        System.out.println("Enter int: ");
        input1 = keyboard.nextInt();        // add an int to grp1
        grp1 += input1;
    }
    else if (answer.equalsIgnoreCase("B")){
        System.out.println("Enter int: ");
        input2 = keyboard.nextInt();        // add an int to grp2
        grp2 += input2;
    }
    else if (answer.equalsIgnoreCase("X")){ 
    }                                       // exit and total
    else {
        System.out.println("Invalid option - Try again.");
    }                                       // Invalid input - restart

}

while (!answer.equals("X"));
keyboard.close();