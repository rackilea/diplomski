private static boolean containsValue(int[] workArray, int value) {

    if (workArray.length == 0) return false;
    if (workArray[0] == value) return true;
    if (workArray.length == 1) return false;

    int middle = workArray.length / 2;

    int[] firstHalfArray = Arrays.copyOfRange(workArray, 0, middle);
    if(containsValue(firstHalfArray, value)) return true;
    int[] secondHalfArray = Arrays.copyOfRange(workArray, middle, workArray.length);
    return containsValue(secondHalfArray, value);

}