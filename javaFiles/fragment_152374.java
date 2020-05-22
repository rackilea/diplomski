public class Array2UniqueID {

private final double min;
private final double max;
private final double prec;
private final int length;

/**
 * Used to provide a {@code BigInteger} that is unique to the given array.
 * <p>
 * This uses weighted sum to guarantee that two IDs match if and only if
 * every element of the array also matches. Similarity is not preserved.
 *
 * @param min smallest value an array element can possibly take
 * @param max largest value an array element can possibly take
 * @param prec smallest difference possible between two array elements
 * @param length length of each array
 */
public Array2UniqueID(double min, double max, double prec, int length) {
    this.min = min;
    this.max = max;
    this.prec = prec;
    this.length = length;
}

/**
 * A convenience constructor which assumes the array consists of doubles of
 * full range.
 * <p>
 * This will result in very large IDs being returned.
 *
 * @see Array2UniqueID#Array2UniqueID(double, double, double, int)
 * @param length
 */
public Array2UniqueID(int length) {
    this(-Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, length);
}

public BigDecimal createUniqueID(double[] array) {
    // Validate the data
    if (array.length != length) {
        throw new IllegalArgumentException("Array length must be "
                + length + " but was " + array.length);
    }
    for (double d : array) {
        if (d < min || d > max) {
            throw new IllegalArgumentException("Each element of the array"
                    + " must be in the range [" + min + ", " + max + "]");
        }
    }

    double range = max - min;

    /* maxNums is the maximum number of numbers that could possibly exist
     * between max and min.
     * The ID will be in the range 0 to maxNums^length.
     * maxNums = range / prec + 1
     * Stored as a BigDecimal for convenience, but is an integer
     */
    BigDecimal maxNums = BigDecimal.valueOf(range)
            .divide(BigDecimal.valueOf(prec))
            .add(BigDecimal.ONE);
    // For convenience

    BigDecimal id = BigDecimal.valueOf(0);

    // 2^[ (el-1)*length + i ]
    for (int i = 0; i < array.length; i++) {
        BigDecimal num = BigDecimal.valueOf(array[i])
                .divide(BigDecimal.valueOf(prec))
                .multiply(maxNums).pow(i);

        id = id.add(num);
    }

    return id;

}