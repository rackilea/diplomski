import java.util.*;

public class MyClass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        char[] arr = new char[16];

        /*taking input from the keyboard*/   
        for(int i = 0; i < 16; i++)
        {
            arr[i] = sc.next().charAt(0);
        }

        /*displaying the contents of the array*/
        for(int i = 0; i < 16; i++)
        {
            System.out.println(arr[i] + ",");
        }
    }
}