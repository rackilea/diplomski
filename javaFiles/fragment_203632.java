for (int row = 1; row <= 10; row++)
{
    for (int star = 1; star <= 10; star++)
    {
        if (star >= row)
        {
            System.out.print("*");
        }
        else
        {
            System.out.print(" ");
        }
    }
    System.out.println();
}