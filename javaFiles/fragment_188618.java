import java.io.*;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
static int add(int a[])
{
    int sum= 0;
    for(int i = 0; i < a.length; ++i)
    {
        sum = sum + a[i];
    }
    return sum;
}

public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    int count = 0;
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int k = 0; k < n; ++k)
    {
        arr[k] = sc.nextInt();
    }
    for(int i = 0; i < n; ++i)
    {
        for(int j = 0; j < n - i; ++j)
        {
            int slice[] = IntStream.range(j, j + i + 1).map(k -> arr[k]).toArray();
            if(add(slice) < 0)
            {
                ++count;
            }
        }
    }
    System.out.println(count);

}
}