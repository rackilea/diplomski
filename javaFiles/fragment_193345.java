import java.util.*;
class randomArr {

    public int[] randomizer()
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Please enter the amount of integers you want in your array: ");
        int n = sc.nextInt();
        // Create array of 1000 ints
        int[] intArr = new int[n];

// Fill array with random ints
        for ( int i = 0; i < intArr.length; i++) {
            intArr[i] = r.nextInt(100);
            System.out.print(intArr[i] + ", ");
        }

        return intArr;

    }

}

class Stack
{
    public static void main(String[] args) 
    {
        randomArr rArr = new randomArr();
        int[] intArr = rArr.randomizer();
    }
}