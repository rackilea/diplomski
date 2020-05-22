private static int partition(int[] givenArray, int start, int end, int pivotIndex) {
    final int pivot = givenArray[pivotIndex];
    int left = start;
    int right = end;
    while (left < right) {
        while (left < givenArray.length && givenArray[left] <= pivot) {
            left++;
        }

        while (right > -1 && givenArray[right] > pivot) {
            right--;
        }

        if (left >= right) {
            break;
        }
        exchange(givenArray, right, left);
    }
    return right;
}