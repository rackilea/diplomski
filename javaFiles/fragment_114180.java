int choice;
boolean keepGoing = true;
while(keepGoing)
{
    System.out.println("---> Your choice: ");
    choice = input.nextInt();
    switch(choice)
    {
        case 1: 
            playGame();
            break;
        case 2: 
            loadGame();
            break;
        // your other cases
        // ...
        case 5: 
            System.out.println("End of Game\n Thank you for playing with us!");
            keepGoing = false;
            break;
        default:
            System.out.println("Not a valid choice!\n Please try again...\n");
     }
 }