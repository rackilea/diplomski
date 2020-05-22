SelectQuery<?> select = create
    .select()
    .from("myTable")
    .where("fk = 1")
    .getQuery();

if (someCondition)
    select.addOrderBy(DSL.field("pk"));