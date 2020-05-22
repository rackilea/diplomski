ObjectContext context = ...
JsonTest t = context.newObject(JsonTest.class);
t.setX("{\"m\":1}");
context.commitChanges();

List<JsonTest> list =
     ObjectSelect.query(JsonTest.class).select(context);