Result<Record2<Integer, String>> result =
DSL.using(configuration)
   .select(row.field1().as("f1"), row.field2().as("f2"))
   .from(t1j)
   .limit(0)
   .fetch();