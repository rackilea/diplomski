public int greatestNegative(int[] list) {
    int result = 0;
    for (int i = 0; i < list.length; i++) {
        if (list[i] < 0) {
            if (result == 0 || list[i] > result) {
                result = list[i];
            }
        }
    }
    return result;
}