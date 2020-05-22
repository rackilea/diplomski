/**
 * Unboxes a List in to a primitive array.
 *
 * @param  list      the List to convert to a primitive array
 * @param  arrayType the primitive array type to convert to
 * @param  <P>       the primitive array type to convert to
 * @return an array of P with the elements of the specified List
 * @throws NullPointerException
 *         if either of the arguments are null, or if any of the elements
 *         of the List are null
 * @throws IllegalArgumentException
 *         if the specified Class does not represent an array type, if
 *         the component type of the specified Class is not a primitive
 *         type, or if the elements of the specified List can not be
 *         stored in an array of type P
 */
public static <P> P toPrimitiveArray(List<?> list, Class<P> arrayType) {
    if (!arrayType.isArray()) {
        throw new IllegalArgumentException(arrayType.toString());
    }
    Class<?> primitiveType = arrayType.getComponentType();
    if (!primitiveType.isPrimitive()) {
        throw new IllegalArgumentException(primitiveType.toString());
    }

    P array = arrayType.cast(Array.newInstance(primitiveType, list.size()));

    for (int i = 0; i < list.size(); i++) {
        Array.set(array, i, list.get(i));
    }

    return array;
}