import java.util.Scanner;
class TestClass {
public static void main(String args[] ) throws Exception {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int a[] = new int[n];
    for(int i=0; i<n; i++)
        a[i] = scan.nextInt();
    for(int i=0; i<n/2; i++)
        swap(i,n-i-1,a);
    for(int i=0; i<n; i++)
        System.out.println(a[i]);

    }

public static void swap(int x, int y, int[] arr){
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
}

}