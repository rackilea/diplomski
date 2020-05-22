import java.util.Arrays;
public class MyClass {
    public static void main(String args[]) {


    int test[] = {7,1,9,1,5,6};
    bubbleSort(test);
    System.out.println(Arrays.toString(test));
    }

    static void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp = 0;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                if(arr[j-1] > arr[j]){  
                    //swap elements  
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;  
                }  
            }  
        }  
    }
}