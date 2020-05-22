while(anotherFlag)
{
    TARGET = generator.nextInt(100) + 1; //establishes the target number

    System.out.print("Can you guess what it   is?\n");

    do 
    {   //beginning the loop
        guess = consoleIn.nextInt(); 
        count++; 

        if (guess > TARGET) 
        System.out.print("Sorry - Your guess is too high \n"); 
        else 
        if (guess < TARGET)
        System.out.print("Sorry - Your guess is too low \n"); 
    }
    while(guess != TARGET && count < 6);

    if(guess == TARGET) {
        System.out.println("Congratulations! - You found it!"); 
        System.out.println();
    }
    else 
    {
        System.out.println("Sorry - You have used all 6 guesses");
    }

    System.out.println();
    System.out.println("Would you like to guess again? (yes/no)");

    another = consoleIn.next(); 


}