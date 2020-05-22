public static <T, U extends UDTRecord> Field<T> dereference(
    Field<? extends U> parent, 
    UDTField<U, T> child
) {
    return DSL.field("({0}).{1}", child.getDataType(), parent, child.getUnqualifiedName());
}