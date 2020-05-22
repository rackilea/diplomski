public static <T> T[] tail(T[] array) {
    if (array.length == 0)
        throw new IllegalArgumentException("Array cannot be empty");

    return java.util.Arrays.copyOfRange(array, 1, array.length);
}