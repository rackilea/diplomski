/**
 * Returns the value of this {@code Double} as a {@code float}
 * after a narrowing primitive conversion.
 *
 * @return  the {@code double} value represented by this object
 *          converted to type {@code float}
 * @jls 5.1.3 Narrowing Primitive Conversions
 * @since JDK1.0
 */
public float floatValue() {
    return (float)value;
}