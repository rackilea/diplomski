import java.util.concurrent.ThreadLocalRandom;  //for shuffling array
import java.util.Random;                        //for shuffling solution

public class BigToSmallArray    {
    public static void main(String[] args)  {
        int[] bigArray = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] smallArray = new int[5];
        int[] shuffledBigArray = shuffleArray(bigArray);
        for(int i = 0; i < smallArray.length; i++)  {
            smallArray[i] = shuffledBigArray[i];
        }
    }

    public static int[] shuffleArray(int arr[])   {
        Random rnd = ThreadLocalRandom.current();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
        return arr;
    }
}