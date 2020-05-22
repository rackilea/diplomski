//making use of j

public static int[] sortArray(int[] nonSortedArray){
    int[] sortedArray = new int[nonSortedArray.length];
    int temp;
    for (int i = 0; i <= nonSortedArray.length; i++) 
    {
        for (int j = i+1; j < nonSortedArray.length; j++)
        {
            if (nonSortedArray[i] > nonSortedArray[j]) 
            {
                temp = nonSortedArray[i];
                nonSortedArray[i] = nonSortedArray[j];
                nonSortedArray[j] = temp;
                sortedArray = nonSortedArray;
            }
        }
    }
    return sortedArray;
}