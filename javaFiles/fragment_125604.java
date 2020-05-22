public static void main(String[] args)
{
    Random rand = new Random();
    int randno = rand.nextInt(100)+1; 
    int dig;

    while(true)
    {
        System.out.println("Number generated. Try your luck!: ");

        in = new Scanner(System.in);
        dig = in.nextInt();    

        if (dig<randno)
        {
            System.out.println("Too low!");
        }
        else if (dig>randno)
        {
            System.out.println("Too high!");
        }
        else
        {
            System.out.println("Correct!");
            break; // Stop the loop
        }
    }
}