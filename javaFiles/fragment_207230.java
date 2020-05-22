public int getTheIndexOfNull(String[] array) {
    int result = -1;
    for (int i = 0; i < array.length; i++) {
        if (array[i] == null) {
             result = i;
             break;
        }
    }
    return result;
}