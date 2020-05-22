import java.util.Scanner;
class TriangleExample
{
    public static void main(String args[])
    {
        int rows, number = 1, counter, j;
        //To get the user's input
        Scanner input = new Scanner(System.in);
        //take the no of rows wanted in triangle
        System.out.println("Enter the number of rows for  triangle:");
        //Copying user input into an integer variable named rows
        rows = input.nextInt();
        System.out.println(" triangle");
        System.out.println("****************");
        //start a loog counting from the first row and the loop will go till the entered row no.
        for ( counter = 1 ; counter <= rows ; counter++ )
        {
            //second loop will increment the coloumn 
            for ( j = 1 ; j <= counter ; j++ )
            {
                System.out.print(number+" ");
                //Incrementing the number value
                number++;
            }
            //For new line
            System.out.println();
        }
    }
}