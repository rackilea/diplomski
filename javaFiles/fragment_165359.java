private <T> T[] loadIntArray(String key, T[] defaultArray) {
    T[] array = new T[4]; // Need more info to correct this
    for (int index = 0; index < 4; index++) {
        array[index] = sp.getInt(key + index, defaultArray[index]);
    }
    return array;
}