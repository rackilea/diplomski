/**
 * Creates an instance of Object multi-dimensional arrays, with dimensions specified by the argument.
 * 
 * @example Create an array Object[4][20][30]:  
 * <pre>
 * Object[] array = newArray(new int[]{4,20,30});
 * </pre>
 * 
 * @param sizes The list of dimension lengths.
 * @return 
 */
public static Object[] newArray(int[] sizes) {
    Object[] result = null;
    if (sizes != null) {
        for(int n = sizes.length - 1; n >= 0; n--) {
            if (result == null) {
                result = new Object[sizes[n]];
            } else {
                Object[] oa = new Object[sizes[n]];
                for (int i = 0; i < sizes[n]; i++) {
                    oa[i] = java.util.Arrays.copyOf(result, result.length);
                }
                result = oa;
            }
        }
        if (result == null) { result = new Object[1]; }
    }
    return result;
}

/**
 * Get the value of a multi-dimensional array element given by a coordinate list.
 * 
 * @example Read the value at [2][14][27]:
 * <pre>
 * Object[] array;  // e.g. a int[4][20][30] created with newArray(int[])
 * int[] coord = new int[]{2,14,27};
 * Object value = getValue(array, coord);
 * </pre>
 * 
 * @param array The coordinates of the array element.
 * @param coordinates
 * @return
 */
public static Object getValue(Object[] array, int[] coordinates) {
    Object result = null;
    if (array == null || coordinates == null || 0 > coordinates[0]||coordinates[0] > array.length) {
        result = null;
    } else {
        int x = coordinates[0];
        if (array[x] instanceof Object[]) {
            int[] c = new int[coordinates.length-1];
            for(int i = 0; i < c.length; i++) { c[i] = coordinates[i + 1]; }
            result = getValue((Object[]) array[x], c);
        } else {
            result = array[x];
        }
    }
    return result;
}

/**
 * Set the value of a multi-dimensional array element given a list designating the element's coordinates.
 * 
 * @example Write a value to [1][0][7]:
 * <pre>
 * Object value;    // e.g. a float
 * Object[] array;  // e.g. a int[4][20][30] created with newArray(int[])
 * int[] coord = new int[]{1,0,7,};
 * setValue(array, coord, value);
 * </pre>
 * 
 * @param array
 * @param coordinates
 * @param value
 * @return
 */
public static void setValue(Object[] array, int[] coordinates, Object value) {
    if (array == null || coordinates == null || array.length == 0 || coordinates.length == 0 || array.length < coordinates[0]||coordinates[0] < 0 ) {
        return;
    } else {
        int x = coordinates[0];
        if (array[x] != null && array[x].getClass().isArray()) {    // recurse
            int[] c = new int[coordinates.length - 1];
            for (int i = 0; i < c.length; i++) { c[i] = coordinates[i + 1]; }
            setValue((Object[]) array[x], c, value); 
        } else {
            array[x] = value;
        }
    }
    return;
}