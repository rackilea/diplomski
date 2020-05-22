import java.util.Scanner;


public class Main {


    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean foundFlag = false;
        String[] values = new String[12];

        //Populate array
        for(int i = 0, x = 1; i < values.length; i ++, x ++)
        {
            System.out.print("Enter name of friend " + x + ": " );
            String name = input.next();
            values[i] = name;
        }

        //Output all elements of the array
        System.out.println("\n" + "The names of your friends are: ");
        for(String x : values)
        {
            System.out.println(x);
        }

        //Find a friend
        System.out.print("\n" + "Enter in the name of the friend you would like to find: ");
        String find = input.next();


        //Iterate through array and check if Friend inside.
        for(int i = 0; i < values.length; i ++)
        {
            if(values[i].toLowerCase().equals(find.toLowerCase()))
            {
                foundFlag = true;
                break;
            }

        }

        //If friend in the array flag will be True, else flag will remain false.
        if (foundFlag)
        {
            System.out.println("Friend " + find + " found");
        }
        else
        {
            System.out.println("Friend " + find + " not found");
        }

    }
}