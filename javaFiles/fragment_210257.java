public int min(int[] a) {                   //assume a has 3 elements
    int min = 0;                            //for storing smallest index
    for (int i = 1; i < a.length, i++) {    //loop index 1,2
        if (a[i] <  a[min]) {               //if current array value < current smallest value
            min = i;                        //store new found smallest index
        }
    }
    return min;                             //returning min, the smallest index 
}