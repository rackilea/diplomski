package x;
import java.util.Arrays;
public class x {
    public static void main(String[] args) {
        int[] myArray = {2, 4, 1, 6, 8, 5, 3, 7};
    mergeSort(myArray);
    System.out.println((Arrays.toString(myArray)));
    }

    public static void mergeSort(int []toSortArray){
        int n= toSortArray.length;
        if (n < 2) {
            return;
        }
        int mid = n/2;
        int []Left = new int [mid];
        int []Right = new int[n-mid];
        for(int i=0;i<mid;i++){
            Left[i]=toSortArray[i];
        }
        for(int i=mid;i<n;i++){
            Right[i-mid]=toSortArray[i];
        }
        mergeSort(Left);
        mergeSort(Right);
        merge(Left,Right,toSortArray);
    }

    public static void merge(int[] Left, int [] Right, int []SortedArray){
        int nL = Left.length;
        int nR= Right.length;

        int i=0;// index position for Left array
        int j=0;// index position for Right array
        int k=0;// index position for Sorted array

        while (i<nL && j<nR){
            if (Left[i]<=Right[j]) {
                SortedArray[k] = Left[i];
                i++;
                k++;
            } else {
                SortedArray[k] = Right[j];
                j++;
                k++;
            }
        }
        while(i<nL){
            SortedArray[k]=Left[i];
            i++;
            k++;
        } while (j<nR){
            SortedArray[k]= Right[j];
            j++;
            k++;
        }
    }
}