Condition joinCondition = fieldByName(leftTable, leftColumn).eq(fieldByName(rightTable, rightColumn));
create.select(columns)
    .from(tableByName(leftTable))
    .join(tableByName(rightTable))
    .on(joinCondition)
    .fetch();