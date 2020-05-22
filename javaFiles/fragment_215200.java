public static <T extends Comparable <T>> int binarySearchIter(T[] data, T key) {
    int first = 0;
    int last = data.length - 1;
    int mid, result;
    while (first <= last) {
        mid = (first + last) / 2;
        result = key.compareTo(data[mid]);
        if (result < 0) {
            last = mid - 1;
        } else if (result > 0) {
            first = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}