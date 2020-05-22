public class fibonacciCalculator {
    static int[] arr = new int[48];
    static int fibo (int n, int arr[]) {
        if ( n == 1|| n == 2 ) {
            return 1; 
        }else if ( n == 0 ) {
            return 0; 
        }
        if (arr[n-1] == 0) {
            arr[n-1] = fibo(n-1, arr);
        }
        if (arr[n-2] == 0) {
            arr[n-2] = fibo(n-2, arr);
        }
        return arr[n-1] + arr[n - 2];
    }   
    public static void main(String[] args) {

        for (int i = 1; i <= arr.length-1; i++) {
            if (arr [i] == 0) {
                arr[i] = fibo(i, arr);
                System.out.print("The Fibonacci number " + i);
                System.out.println(" is: " + arr[i]);
            }       
        }
    }
}