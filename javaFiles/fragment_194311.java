public static boolean hasDuplicate(int numOfElement, int[] numArr) {
    boolean found = false;
    int i = 0;
    while (!found && i < numOfElement) {
        int j = i + 1;
        while (!found && j < numOfElement) {
            if (numArr[i] == numArr[j]) {
                found = true;
            }
        }
    }
    return found;
}