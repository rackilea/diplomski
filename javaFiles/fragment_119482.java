import java.util.Arrays;
...
public static void main(String args[])
{
    int arr[] = { 1, 2, 3, 4, 5, 6 };
    fun(Arrays.copyOfRange(arr, 2, arr.length), 3);
}

public static void fun(int a[], int n)
{
    for (int i = 0; i < n; i++) {
        System.out.printf("%d ", a[i]);
    }
}