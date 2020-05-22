public void printTrapezoid(Scanner sc)
{
    int width;
    int rows;

    System.out.print("Enter height: ");
    rows = sc.nextInt();

    System.out.print("Enter width: ");
    width = sc.nextInt();

    System.out.println();

    for (int i = rows - 1; i >= 0; --i)
    {
        int blocks = width - i * 2;
        for (int j = 0; j < i; ++j)
        {
          System.out.print(" ");
        }
        for (int j = 0; j < blocks; ++j)
        {
          System.out.print("@");
        }

        System.out.println();
    }

    System.out.println("");
}