import java.util.Scanner;//import scanner so user can input

class arrays
{

    public static void main(String[] param)
    {
        String[] animals = arrays();
        forloop(animals);
        System.exit(0);
    } //end main method

    public static String[] arrays() //array method 
    {
        String[] animals = new String[5]; //array to store 5 animals

        animals[0] = "Komodo Dragon"; //animals stored
        animals[1] = "Manatee";
        animals[2] = "Kakapo";
        animals[3] = "Florida Panther";
        animals[4] = "White Rhino";

        return animals;
    }

    public static void forloop(String[] animals)
    {

        for(int i =0; i<5; i++) //for loop to print the below 
        //print 5 times using the different animal names.
        {
            System.out.println(animals[i] + ": How many are left in the wild?");
        }
    }

}