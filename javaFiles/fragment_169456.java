String choice = in.next();
if (choice.equalsIgnoreCase("y")) 
{
    System.out.println("Maybe you'll win this time!");
    money = 1000;
    rollDice();
} 
else if (choice.equalsIgnoreCase("n")) // <-- not in.next()