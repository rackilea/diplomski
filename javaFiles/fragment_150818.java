public static int[] swap(int[] swapping){
    int max = 0;
    int min = 0;
    for(int i = 1; i < swapping.length; i++){
        if(swapping[i] > swapping[max]){
            max = i;
        }
        if(swapping[i] < swapping[min]){
            min = i;
        }
    }
    int temp = swapping[min];
    swapping[min] = swapping[max];
    swapping[max] = temp;
    return swapping;
}