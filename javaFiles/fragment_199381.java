public String toString()
{
    System.out.println("Shown are the prices for " +
            "each seat. A 0 indicates the seat is " +
            "unavailable.");
    for(int i = 0; i < 9; i++)
    {
        for(int j = 0; j < 10; j++)
        {
            System.out.printf("%8d", seatArray[i][j]);
        }
    }
    return someString; // return statement is required as the method return type is String and not void
}