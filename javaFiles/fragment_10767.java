@SuppressWarnings({ "rawtypes", "unchecked" })
static <T> Field<T[]> array(Select<? extends Record1<T>> select) {
    return DSL.field("array({0})", (DataType) 
        select.getSelect().get(0).getDataType().getArrayDataType(), select);
}

static Field<Integer> arrayLength(
    Field<? extends Object[]> array,
    Field<Integer> dimension
) {
    return DSL.field("array_length({0}, {1})", Integer.class, array, dimension);
}