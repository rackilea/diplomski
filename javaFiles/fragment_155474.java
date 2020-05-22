@SqlResultSetMappings( {
        @SqlResultSetMapping(
                name = "calendarsCoreInfoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = CalendarsCoreInfo.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Long.class),
                                        @ColumnResult(name = "email", type = String.class),
                                        @ColumnResult(name = "original_id", type = String.class),
                                        @ColumnResult(name = "read_only"),
                                        @ColumnResult(name = "deleted")
                                }
                        )
                }
        ),
})