public static <T, C extends Collection<T>> Condition contains(
    Field<? extends C> left, 
    C right
) {
    return DSL.condition("{0} @> {1}::text[]", left, DSL.val(right, left.getDataType()));
}