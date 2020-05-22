public static void main(String args[])
{
    Scanner sc = new Scanner(System.in);
    int num;
    int i = 0;

    System.out.print("Please enter a number: ");
    num = sc.nextInt();

    if(num < 10)
    {
        while(i < 7)
        {
            System.out.println("Less than 10");
            i++;
        }
    }

    if(num>10)
    {
        while(i < 4)
        {
            System.out.println("greater than 10");
            i++;
        }
    }

}