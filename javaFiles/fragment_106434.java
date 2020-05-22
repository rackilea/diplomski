public static int smallestNumber (int[] array1) {

    int smallest;

    if (array1 == null || array1.length == 0) {
        return 0;
    }

    else {
        smallest = array1[0];
        for (int element : array1) {
            if (element < smallest) {
                smallest = element;
            }
        }
    }
    return smallest;
}