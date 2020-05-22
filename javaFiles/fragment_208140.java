/**
 * Compares the two specified {@code float} values. The sign
 * of the integer value returned is the same as that of the
 * integer that would be returned by the call:
 * <pre>
 *    new Float(f1).compareTo(new Float(f2))
 * </pre>
 *
 * @param   f1        the first {@code float} to compare.
 * @param   f2        the second {@code float} to compare.
 * @return  the value {@code 0} if {@code f1} is
 *          numerically equal to {@code f2}; a value less than
 *          {@code 0} if {@code f1} is numerically less than
 *          {@code f2}; and a value greater than {@code 0}
 *          if {@code f1} is numerically greater than
 *          {@code f2}.
 * @since 1.4
 */
public static int compare(float f1, float f2) {
    if (f1 < f2)
        return -1;           // Neither val is NaN, thisVal is smaller
    if (f1 > f2)
        return 1;            // Neither val is NaN, thisVal is larger

    // Cannot use floatToRawIntBits because of possibility of NaNs.
    int thisBits    = Float.floatToIntBits(f1);
    int anotherBits = Float.floatToIntBits(f2);

    return (thisBits == anotherBits ?  0 : // Values are equal
            (thisBits < anotherBits ? -1 : // (-0.0, 0.0) or (!NaN, NaN)
             1));                          // (0.0, -0.0) or (NaN, !NaN)
}