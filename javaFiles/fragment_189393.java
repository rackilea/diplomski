private static void merge(int[] arr, int[] temp, int lower, int mid, int upper) {
    int tempIndex = 0;
    int leftLo = lower;
    int leftHi = mid - 1;
    int rightLo = mid;
    int rightHi = upper;

    while (leftLo <= leftHi && rightLo <= rightHi) {
        if (arr[leftLo] < arr[rightLo]) {
            temp[tempIndex] = arr[leftLo];
            tempIndex++;
            leftLo++;
        } else {
            temp[tempIndex] = arr[rightLo];
            tempIndex++;
            rightLo++;
        }
    }
    while (leftLo <= leftHi) {
        temp[tempIndex] = arr[leftLo];
        tempIndex++;
        leftLo++;
    }
    while (rightLo <= rightHi) {
        temp[tempIndex] = arr[rightLo];
        tempIndex++;
        rightLo++;
    }
}