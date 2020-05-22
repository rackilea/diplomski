public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    int[] copyOfAUsingIteration = copyArrayUsingIteration(a);
    int[] copyOfAUsingRecursion = copyArrayUsingRecursion(a);
    assert(Arrays.equals(copyOfAUsingIteration, copyOfAUsingRecursion));
    assert(copyOfAUsingIteration != a);
    assert(copyOfAUsingRecursion != a); 
    System.out.println(java.util.Arrays.toString(copyOfAUsingIteration));
    System.out.println(java.util.Arrays.toString(copyOfAUsingRecursion));
}

static int[] copyArrayUsingIteration(int[] arrayToCopy) {
    int[] result = new int[arrayToCopy.length];
    for(int index = 0; index < result.length; index++){
        result[index] = arrayToCopy[index];
    }
    return result;
}

static int[] copyArrayUsingRecursion(int[] arrayToCopy){
    if (arrayToCopy.length == 0){
        return new int[0];
    } else {
        int[] result = new int[arrayToCopy.length];
        copyValuesFromSourceToDestinationStartingAtIndex(arrayToCopy, result, 0);
        return result;
    }
}

static void copyValuesFromSourceToDestinationStartingAtIndex(int[] source, int[] destination, int index) {
    if (isIndexOfLastElementInArray(index, destination)) {
        destination[index] = source[index];
    } else {
        destination[index] = source[index];
        copyValuesFromSourceToDestinationStartingAtIndex(source, destination, index + 1);
    }
}

static boolean isIndexOfLastElementInArray(int index, int[] array){
    return index == array.length - 1;
}