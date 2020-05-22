public static int[] collapseThis(int[] array) {

    int size = 0;

    if(isEven(array.length))
        size = array.length/2;
    else
        size = array.length/2+1;

    int[] collapsedArray = new int[size];

    for(int i=0, j=0; j<=size-1; i++, j++) {

        if(j==size-1 && !isEven(array.length)) {
            collapsedArray[j] = array[2*i];
        }
        else {
            collapsedArray[j] = array[2*i]+array[2*i+1];
        }
    }
    return collapsedArray;
}

private static boolean isEven(int num) { 
    return (num % 2 == 0); 
}