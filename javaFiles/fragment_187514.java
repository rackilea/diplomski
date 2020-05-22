import java.util.Arrays;

public class Driver {


    private static final int MAX = 0;

    public Driver() {
        int[] randomArray = new int[MAX];
        int sum;
        final int MAX;
    }

    public int getAverage() {
        int average = 0;
        for (int index = 0; index < MAX; index++) {
            int sum = 0;
            int[] randomArray = null;
            sum = sum + randomArray[index];
            average = sum / MAX;
        }
        return average;
    }

    public void sortArray(int[] randomArray) {
        // sort the array from smallest to biggest
        Arrays.sort(randomArray);

        System.out.println("The sorted array from smallest to biggest is:");
        for (int number : randomArray) {
            System.out.println(+number);
        }
    }

    public int getMin(int[] randomArray) {
        // find the lowest number
        return randomArray[0];

    }

    public int getMax(int[] randomArray) {
        // find the highest number
        return randomArray[MAX];

    }
}