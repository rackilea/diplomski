public int findMin(int[] array) { 
    int[] aux = new int[array.length];
    for (int i = 0; i < array.length; i++) 
        aux[i] = -1 * array[i];
    int min = -1 * findMax(aux); 
    return min; 
}