public static int performBinarySearch(int[] numArray, int userValue) {
    int first = 0;
    int middle;
    int last = (numArray.length - 1);
    int iteration = 0;
    boolean found = false;
    while ((!found) && (first <= last)) {
        iteration++;
        middle = ((first + last) / 2);
        if (numArray[middle] == userValue) {
            found = true;
            break;
        }
        if (numArray[middle] > userValue) {
            last = (middle - 1);
        }

        if (numArray[middle] < userValue) {
            first = (middle + 1);
        }
    }
    if (found) return iteration;
    else return -1;
}