import java.io.*;
import java.util.*;
import java.lang.*;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Dimension of Matrix");

        int N = sc.nextInt();
        int[][] m = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.out.println("Enter Elements of row " + i);
            for (int j = 0; j < N; j++) {
                m[i][j] = Integer.valueOf(sc.next());//replaced line with proper code
            }
        }
        sc.close();
        System.out.println(Arrays.deepToString(m));//use this api to print arrays
    }
}