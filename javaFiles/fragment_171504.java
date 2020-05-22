public static void main(String[] args)
{
    Scanner in = new Scanner(System.in);
    int year = -1; //Give your int a default value so the main loop will execute
    while (year != 0) //-1 not equal to zero, so your code will start
    {
        System.out.print("Please enter a year: "); //Now we get the value of the year
        year = in.nextInt(); //Put it into our variable
        if (year < 1582) //And if it's less than 1582
        {
            if (year != 0)
                System.out.println("Year must not be less than 1582!"); //Notify the user, unless they are exiting the program
            continue; //restart the while loop, this is quite a useful statement!
        }
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) //Check if it's a leap year
            System.out.println("That is a leap year!\n"); 
        else
            System.out.println("That is not a leap year :(\n");
        //End of the loop, so it goes back to the beginning, which asks the user again for the year
        //So if you enter 0 next the program will close
    }
}