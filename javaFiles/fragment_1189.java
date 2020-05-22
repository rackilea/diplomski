public int findMin(int[] array) { 
    for (int i = 0; i < array.length; i++) 
        array[i] *= -1;
    int min = -1 * findMax(array); 
    for (int i = 0; i < array.length; i++) 
        array[i] *= -1;
    return min; 
}