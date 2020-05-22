public static int myArray(int[] a) {
    int len = a.length;
    if (checkLenght(len)) {
        int firstElem = a[0];
        int pointer = 2;                     // pointer that will be 2, 3, 4 , ...
        int sum = 0;                         // sum of element in each partition
        int temp = 0;                        // a temp value to check if I reach desirable number of element in this partition or not.
        for (int i = 1; i < a.length; i++) { // i<=a.length give you exception.
            temp++;                          
            sum += a[i];
            if (temp == pointer) {           // check if I have enough element.
                pointer++;                   // plus pointer by one
                temp = 0;                    // reset temp
                if (sum != firstElem)        // if in any of those partitions my needs doesnt meet I return zero.
                    return 0;
                sum = 0;                     // reset sum
            }
        }
        return 1;
    }
    return 0;
}