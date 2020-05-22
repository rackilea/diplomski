if(rollNum == 3)
{
    System.out.println("You lose.\n");
    System.out.println("Would you like to play again?");
    //playAgain = sc.nextLine();

    // Change your nextLine() to next()
    playAgain = sc.next();
    rollNum ++;
}