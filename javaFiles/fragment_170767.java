Foo foo = new Foo();
foo.stringField = "اعصاب";
dao.create(foo);
List<Foo> results = dao.queryBuilder().where()
   .like(Foo.STRING_COLUMN_NAME, foo.stringField).query();
assertEquals(foo.stringField, results.get(0).stringField);