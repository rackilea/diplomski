/**
 * Returns the string representation of the {@code Object} argument.
 *
 * @param   obj   an {@code Object}.
 * @return  if the argument is {@code null}, then a string equal to
 *          {@code "null"}; otherwise, the value of
 *          {@code obj.toString()} is returned.
 * @see     java.lang.Object#toString()
 */
public static String valueOf(Object obj) {
    return (obj == null) ? "null" : obj.toString();
}