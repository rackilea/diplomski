SqlResultSetMapping(
    name="workorder",
    classes={
        @ConstructorResult(
            targetClass=WorkOrderDTO.class,
            columns={
                @ColumnResult(name="wo_number", type = Long.class),
                @ColumnResult(name="service_types", type = String.class),
                @ColumnResult(name="order_title", type = String.class)
            }
        )
    }
)