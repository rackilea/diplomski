NumberExpression<Long> rowNumber = SQLExpressions.rowNumber()
    .over()
    .partitionBy(employee.name)
    .orderBy(employee.id).as("rowNumber");

query.select(employee.name, employee.id)
    .from(SQLExpressions.select(employee.name, employee.id, rowNumber)
                        .from(employee).as(employee))
    .where(Expressions.numberPath(Long.class, "rowNumber").eq(1L))
    .fetch();