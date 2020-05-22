public Class2(int[] array, int index, int number){
    for (int i = 0; i < array.length; i++) {
        array2[i] = array[i];
    }
    if (index >= 0 && index < array2.length){
        array2[index] = number;
    }
}