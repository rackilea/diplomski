import java.util.Random;

public class MinMax {

    public static int min(int... args) {
        int m = Integer.MAX_VALUE;
        for (int a : args) {
            m = Math.min(m, a);
        }
        return m;
    }

    public static int max(int... args) {
        int m = Integer.MIN_VALUE;
        for (int a : args) {
            m = Math.max(m, a);
        }
        return m;
    }

    public static void main(String[] args) {

        // fill an array with random numbers between 0 and 50
        int[] ar = new int[10];
        for (int i = 0; i < 10; i++)
        {
            ar[i] = new Random().nextInt(50);
            System.out.println(ar[i]);
        }

        int maxValue = max(ar);
        int minValue = min(ar);

        System.out.println("The max is " + maxValue);
        System.out.println("The min is " + minValue);
    }
}