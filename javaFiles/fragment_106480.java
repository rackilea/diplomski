public static int mergeSort(int[] intArray, int comparisons) {

    if(intArray.length >= 2) {

        int mid = intArray.length / 2;
        //Create 2 arrays to store half of the data in each
        int[] first = new int[mid];     //holds first half of array
        int[] second = new int[intArray.length - mid];  //holds second half of array

        for(int i = 0; i < first.length; i++) { 
            first[i] = intArray[i];     
        }

        for(int i = 0; i < second.length; i++) {
            second[i] = intArray[mid+i];
        }

        comparisons = mergeSort(first, comparisons);
        comparisons = mergeSort(second, comparisons);
        comparisons = merge(first, second, intArray, comparisons);     //Merge all together

    }

    return comparisons;
}

//merging first and second halves of mergeSort array
public static int merge(int[] first, int[] second, int[] intArray, int comparisons) {

    int iFirst = 0;
    int iSecond = 0;
    int i = 0; 

    //moving the smaller element into intArray
    while(iFirst < first.length && iSecond < second.length) {

        comparisons++;

        if(first[iFirst] < second[iSecond]) {
            intArray[i] = first[iFirst];
            iFirst++;
        }

        else {
            intArray[i] = second[iSecond];
            iSecond++;
        }
        i++;
    }


    //copying the remaining of first array
    while(iFirst < first.length) {
        intArray[i] = first[iFirst];
        iFirst++; i++; 
    }

    //copying the remaining of second array
    while(iSecond < second.length)
    {
        intArray[i] = second[iSecond];
        iSecond++; i++; 
    } 

    return comparisons;
}