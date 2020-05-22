import java.util.Random;

public class Main {
    public static void main(String args[])
    {
    /*
    (a) Create an array of integers called aRand of capacity 20 and initialize its entries to 0. 
    */
        int aRand[] = new int[20];

        populateArray(aRand); // We already know aRand is an int[]

    }

    /*
    (b) Populate the array in a method called populateArray(int[] array) where array is the one you want to populate. 
    This method returns void. 
    */
    public static void populateArray(int[] array){
        Random rand = new Random();
        for (int i=0; i<array.length; i++){
            array[i] = rand.nextInt();
            System.out.println(array[i]);
        }
    }
}