public class AlphaTest
{
public static void processA(int[] arr)
{
    for (int i = 0; i < arr.length; i++)
        if (arr[i] > 0)
            System.out.print("");
}

public static void processB(int[] arr)
{
    for (int i = 0; i < arr.length; i++)
        if (0 < arr[i])
            System.out.print("");
}

public static void main(String[] args)
{
    int[] smallArr = new int[10];
    for (int i = 0; i < smallArr.length; i++)
    {
        smallArr[i] = 1;
    }
    //warmup
    for (int i = 0; i < 11000; i++)
    {
        processA(smallArr);
        processB(smallArr);
    }

    int[] arr = new int[100000000];
    arr[99999999] = 1;
    long t1, t2, t3;
    for (int ndx = 0; ndx < 10; ndx++)
    {
        t1 = System.nanoTime();
        processA(arr);

        t2 = System.nanoTime();
        processB(arr);

        t3 = System.nanoTime();
        System.out.println(((t2 - t1)/1000000L) + " " + ((t3 - t2)/1000000L));
    }
}
}