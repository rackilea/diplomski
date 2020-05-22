for (int i = 0 ; i + 5 < array.length; i++) 
{
    int total = 0;
    for (int j = 0; j < 5 ; j++)
    {
        total += array[i + j];
    }
    System.out.printf("Average is: %.1f%n", total / 5);