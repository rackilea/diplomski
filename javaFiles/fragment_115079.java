do
{
    userInput = keyboard.nextInt(); 
    if (userInput % 2 == 0)
        System.out.println("That is not an Odd Integer!");            
    if(userInput < 0)
        System.out.println("That is not a Positive Odd Integer");
} while(userInput < 0 || userInput %2 == 0);