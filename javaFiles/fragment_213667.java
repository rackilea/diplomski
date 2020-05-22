public static void printTicket(int [] array)
{
    int i;
    for(i = 0; i < array.length ; i++)
    {
        if (i == array.length - 1) 
        {
            System.out.print("MEGA: ");
        }
        System.out.print(array[i]);
        System.out.print(" ");
    }