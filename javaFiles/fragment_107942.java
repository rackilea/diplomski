for (Table<?> t : Public.PUBLIC.getTables()) {
    CreateTableAsStep<?> a = create.createTable(t);
    CreateTableColumnStep b = null;

    for (Field<?> f : t.fields())
        if (b == null)
            b = a.column(f, f.getDataType());
        else
            b = b.column(f, f.getDataType());

    b.execute();
}