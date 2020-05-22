import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DelElem {

    static int[] a = {5,1,2,3,4,5,7,8,9,10};
    static int[] b = new int[10];
    static int f, i, k, j = 0;
    static int l = a.length;

    static void DeleteElementInt(int elementToDelete) {
        j = 0;
        for (int i = 0; i < l; i++)
            if (a[i] != elementToDelete)
                b[i - j] = a[i];
            else
                ++j;
    }



    public static void main(String[] args) {
        System.out.println("Array elements are:");
        for (i = 0; i < a.length; i++)
            System.out.println(a[i]);
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.print("Enter the element to be deleted: ");
        try {
            String s = br.readLine();
            f = Integer.parseInt(s);
            DeleteElementInt(f);
            System.out.println("New array:");
            for (i = 0; i < l - j; i++)
                System.out.println(b[i]);
            if (j == 0)
                System.out.println("Entered element was not found in the given array");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}


//output
/*
Array elements are:
5
1
2
3
4
5
7
8
9
10
Enter the element to be deleted: 5
New array:
1
2
3
4
7
8
9
10
*/