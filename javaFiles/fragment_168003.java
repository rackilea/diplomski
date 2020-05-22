public static final int[] EMPTY_INT_ARRAY = new int[0];

public static int[] toPrimitive(Integer[] array) {
    if (array == null) {
       return null;
    }
    if (array.length == 0) {
       return EMPTY_INT_ARRAY;
    }
    int[] result = new int[array.length];
    for (int i = 0; i < array.length; ++i) {
        result[i] = array[i].intValue();
    }
    return result;
}