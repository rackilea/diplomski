public class Test1 {

static long sum2(int[] arr) {
    long n = arr.length;
    long sum = 0;
    for (int i = 0; i < n; i++) {
        sum += (n-i)*(i+1)*arr[i];
    }
    return sum;
}

static int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9};
static int[] arr2 = new int[]{1,1,1,1};

public static void main(String[] args) {
    System.out.println("sum(arr1) = " + sum(arr1));
    System.out.println("sum2(arr1) = " + sum2(arr1));
    System.out.println("sum(arr2) = " + sum(arr2));
    System.out.println("sum2(arr2) = " + sum2(arr2));
}

//your code to check
static long sum(int[] arr) {
    long sum=0;
    int j,k;
    long sumtoadd;
    for (int i = 0; i < arr.length; i++)
    {
        for (j = i; j < arr.length; j++)
        {
            sumtoadd = 0;
            for (k = i; k <= j; k++)
            {
                sumtoadd = sumtoadd + arr[k];
            }
            sum = sumtoadd + sum;
        }
    }
    return sum;
}