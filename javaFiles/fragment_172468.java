/**
 * If a value is present, returns the value, otherwise returns
 * {@code other}.
 *
 * @param other the value to be returned, if no value is present.
 *        May be {@code null}.
 * @return the value, if present, otherwise {@code other}
 */
public T orElse(T other) {
    return value != null ? value : other;
}