import java.util.Random;

public class ArrayPractice
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int[] a = new int[10];

        for (int i = 0; i < 10; i++)
        { 
            int rnd = 1 + random.nextInt (100);
            a[i] = rnd;
            System.out.print (a [i] + " ");
            for (int j = 0; j < i; ++j)
            {
                if (a[j] == rnd) --i;
            }
        }
    }
}