public static int indexOfSmallest(int[] array){

    // add this
    if (array.length == 0)
        return -1;

    int index = 0;
    int min = array[index];

    for (int i = 1; i < array.length; i++){
        if (array[i] <= min){
        min = array[i];
        index = i;
        }
    }
    return index;
}