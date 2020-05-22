public boolean isArrayFull(Integer[] array) {
    for (Integer i = 0; i < array.length; i++) {
        if (array[i] == null) {
            return false;
        }
    }
    return true;
}