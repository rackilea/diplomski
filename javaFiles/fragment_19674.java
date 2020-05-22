DSLContext ctx;

String createTableSql = ctx.createTable("TABLE_NAME")
        .column("TABLE_ID", SQLDataType.BIGINT.identity(true))
        .column("COL_1", SQLDataType.VARCHAR(64).nullable(false))
        .constraints(
            DSL.constraint("PK_TABLE").primaryKey("TABLE_ID"),
            DSL.constraint("UNIQUE_COL_1").unique("COL_1")
        ).getSQL();

System.out.println(createTableSql);