String sortField = "id";
SortOrder sortOrder = SortOrder.ASC;

Query query = context.select()
    .from("table1")
    .where(DSL.field("report_date").eq(DSL.param("bizdate")))
    .orderBy(DSL.field(sortField).sort(sortOrder));