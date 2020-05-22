import java.util.Scanner;

public class Week
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); //Scanner used to get input from the user
        String[] names = new String[50]; //The array for names remember arrays index began with 0 not 1
        int[] scores = new int[50]; //Again arrays began with 0 not 1 and the last is n-1
        int last = 0; //Used to store the last added ID
        String command; //The command from the user
        boolean running = true; //Whenever the program is running or not
        while(running)
        {
            System.out.println("please enter either: quit, put name mark, get name"); //Print the command list
            command = input.nextLine(); //The next input line (This will make the Thread pause untill it get and input)
            if(command.equals("put mark")) //If the command is "put mark"
            {
                if(last == 49) //Check because we can create and Exception by adding too much element to and array
                    System.out.println("Max number of people reached"); //So we can't add more people
                else
                {
                    System.out.println("Enter Student Name"); //Print the questin
                    names[last] = input.nextLine(); //The name
                    System.out.println("Enter Score"); //Ask for the score
                    scores[last] = input.nextInt(); //Get the score ,because score is a double we should use double so it can take numbers like 0.1
                    last++; //Increment last with 1
                }
            }else if(command.equals("get name"))
            {
                System.out.println("please enter the name you would like to display the score for");
                String name = input.nextLine(); //Get the name
                for(int i = 0; i < last; i++) //Loop untill we hit the last added name's ID
                    if(names[i].equals(name)) //Check if the names[i] is the name that we're searching for
                        System.out.println(name + " 's score is " + scores[i]); //If it's then we print it out
            }else if(command.equals("quit"))
            {
                running = false; //The loop will never run again
                //Implement sorting for youself I would use Map<K, V> but you didn't learned it so..
                //In this case you have to make 1 loop to sort both of the arrays by sorting the second array
                //and when you move anything must it in both arrays I can't help you to make this sorry

                for(int i = 0; i < last; i++) //We print the sorted arrays of the people and their scores
                    System.out.println(names[i] + " 's score is " + scores[i]); //Let's print it
            }
        }


    }
}