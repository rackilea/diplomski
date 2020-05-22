Foo foo = (Foo) session.createQuery(
    "from Foo as foo where foo.s = :str and foo.f = :val order by foo.i desc")
    .setParameter("str", <stringgoeshere>).setParameter("val", <floatgoeshere>)
    .setMaxResults(1)
    .uniqueResult();
return foo;