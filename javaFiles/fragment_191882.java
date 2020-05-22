@SqlResultSetMapping(
        name = "BookValueMapping",
        classes = @ConstructorResult(
                targetClass = BookValue.class,
                columns = {
                    @ColumnResult(name = "id", type = Long.class),
                    @ColumnResult(name = "title"),
                    @ColumnResult(name = "version", type = Long.class),
                    @ColumnResult(name = "authorName")}))