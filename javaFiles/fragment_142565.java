public static int[] count(int[] array) {
    int[] result = new int[6];
    for (int i = 0; i < array.length; i++) {
        try{
            result[array[i]-1]++;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("The numbers must be between 1 and 6. Was " + String.valueOf(array[i]));
        }
    }
    return result;
}