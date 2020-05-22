public static boolean isIncreasing(int[] array){
    int arraylength = array.length;
    for (int i = 0; i < arraylength - 1; i++) {
        if(array[i] > array[i + 1])
            return false;
    } 
    return true;
}