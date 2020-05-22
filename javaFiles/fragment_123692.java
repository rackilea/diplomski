import java.util.Scanner;


 public class Username
{


public static void main (String[]args)


{   
    Scanner kb = new Scanner (System.in);
    // array containing usernames 
    String [] name = {"barry", "matty", "olly","joey"}; // elements in array

    int j = 0;
outerloop:  while (j < 3)
            {

                System.out.println("Enter your name");
                String name1 = kb.nextLine();
                boolean b = true;

                for (int i = 0; i < name.length; i++) {

                    if (name[i].equals(name1))
                    {

                        System.out.println("you are verified you may use the lift");
                        break outerloop;// to stop loop checking names

                    }



                }
                System.out.println("wrong");
                ;j++;

            }

}}