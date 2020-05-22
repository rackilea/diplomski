while (quit != 'N') 
{
    game.play();

    System.out.println("Play again? Press any key to continue, or 'N' to quit");
    String test = scan.nextLine().toUpperCase();
    if(test != null && test.length() > 0)
    {
       quit = test.toUpperCase().charAt(0);
    }
    else
    {
         //handle your else here
         quit = ' '; //this will keep it from terminating
    }
}