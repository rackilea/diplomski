String query =
    "select foo, bar from  FooEntity as foo, BarEntity as bar "+
    "where  foo.someothercol = 'foo' and foo.somecol = bar.somecol";
List<Object[]> results = em.createQuery(query).getResultList();

for (Object[] fooAndBar: results) {
    FooEntity foo = (FooEntity) fooAndBar[0];
    BarEntity bar = (BarEntity) fooAndBar[1];
    //do something with foo and bar
}