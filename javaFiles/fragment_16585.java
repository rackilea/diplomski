public static int binSearch_r (int[] data, int value, int from, int to) {
    if (from <= to) {
        int middle = (from+to)/2;

        if (data[middle] > value) {
            return binSearch_r(data, value, from, middle - 1);
        } else if (data[middle] < value) {
            return binSearch_r(data, value, middle+1, to);
        }
        return middle;            
    }
    return -1;
}