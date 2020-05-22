public static boolean tripleUp(int[] array)
{
    for (int i = 0; i < array.length - 2; ++i) {
        if (array[i+1] == array[i] + 1 && array[i+2] == array[i] + 2) {
            return true;
        }
    }
    return false;
}