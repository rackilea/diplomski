while ((input.equals("y")))
{
    cont = true;
    double a = (40);
    double b = (30);
    double height = (Math.random() * (b - a + 1) + a);
    for (int x = 1; x <= height; x++)
    {
        for (int y = 0; y < height - x; y++) 
        {
            System.out.print(" ");
        }
        for (int y = 0; y < x; y++) 
        {
            System.out.print("x ");
        }
        System.out.println();

    }
    System.out.println ("Do you want to see a triangle? Insert y to continue");
    input = scan.next();

}

    System.out.println();
    System.out.println ("Program ended");