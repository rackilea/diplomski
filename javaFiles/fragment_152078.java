ResultQuery<?> query(
    Supplier<Collection<SelectField<?>>> select,
    boolean condition,
    boolean paginate
) {
    Condition whereClause = ...;
    Table<?> from = table("TableA");
    if (condition)
        from = from.join(table("TableB")).on(field("ColumnA").eq(field("ColumnB")));

    return select(select.get())
          .from(from)
          .where(whereClause)
          .limit(paginate ? 10 : Integer.MAX_VALUE); // Could be done differently
}