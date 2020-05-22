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