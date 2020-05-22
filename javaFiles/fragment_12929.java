public static boolean allLess(final int[] array1, final int[] array2){
    for(int i = 0; i < Math.min(array1.length, array2.length); i++)
        if(array1[i] >= array2[i])
            return false;
    return true;
}