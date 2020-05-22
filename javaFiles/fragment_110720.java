// check if element exists in the array
boolean isInArray(int[] array, int element) {
    for(int i = 0; i < array.length; i++) {
        if(array[i] == element) {
            return true;
        }
    }
    return false;
}