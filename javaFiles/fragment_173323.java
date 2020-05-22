import java.util.Arrays;

public class TestString
{
    public static void main(String[] args)
    {
        String s = "hello";
        int[] a  = new int[5];
        Arrays.fill(a, -1);

        s = fun(s,a);

        System.out.println(s);
        System.out.println(a[0]);
    }

    static String fun(String s, int[] a)
    {
        s = "world";
        a[0] = 99;

        return s;
    }
}