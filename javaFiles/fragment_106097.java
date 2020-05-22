public class Quicksort {

char[] myArray;

public String sort(String myStr){

    if(myStr == null || myStr.length() == 0 || myStr.length() == 1){
        return null;
    }
    int length = myStr.length();
    int low =0,high = length -1;
    this.myArray = myStr.toCharArray(); 

    quickSort(low,high);
    return new String(myArray);

}

public static void quickSort(int low, int high){

    int i = low;
    int j = high;
    char tmp;

    int pivot = (low+high)/2;

    while (i <= j) {
        while(myArray[i] < myArray[pivot]){
            i++;
        }
        while(myArray[j] > myArray[pivot]){
            j--;
        }

        if(i <= j) {
            tmp = myArray[i];
            myArray[i] = myArray[j];
            myArray[j] = tmp;
            i++;
            j--;
        }
    }

    if(low < j){
        quickSort(low, j);
    }
    if(i < high){
        quickSort(i,high);
    }
    System.out.println(myArray);
}