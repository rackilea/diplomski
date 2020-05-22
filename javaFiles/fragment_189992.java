import java.util.*;

class Tuple implements Comparable<Tuple>
{
    int x;
    int y;
    Tuple(int a, int b)
    {
        x = a;
        y = b;
    }

    public int compareTo(Tuple another)
    {
        return Integer.compare(x, another.x);
    }
}

class Main
{
    public static void main(String args[])
    {
        int a[] = {1, 2, 4, 5, 3};
        int b[] = {8, 7, 6, 3, 2};
        Tuple arr[] = new Tuple[a.length];
        for (int i=0;i<a.length;i++)
            arr[i] = new Tuple(a[i], b[i]);
        Arrays.sort(arr);
        for (int i=0;i<a.length;i++)
        {
            a[i] = arr[i].x;
            b[i] = arr[i].y;
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}