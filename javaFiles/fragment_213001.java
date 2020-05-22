int y;
    Scanner input = new Scanner( System.in);
    System.out.println("java DisplayNumberSystems");
    System.out.println("Enter a decimal value to display to: ");
    y = input.nextInt();

    while(y <=1024)
{   

    for(int x=0; x <=y; x++)
    {
        convertToBinary(x);
    }
}