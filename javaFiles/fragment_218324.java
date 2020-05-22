public static int rollDice()
{
    Random rand = new Random();
    int roll = rand.nextInt(6) + 1;
    return roll;
}