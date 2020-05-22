List<SortField<?>> orderBy = new ArrayList<>();

if (someCondition)
    orderBy.add(DSL.field("pk").asc());

create.select()
      .from("myTable")
      .where("fk = 1")
      .orderBy(orderBy);