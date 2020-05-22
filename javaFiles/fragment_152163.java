public A fetch(Integer id) {
    // try-catch abstracted
    Query query = getSession.createQuery("from A a where a.id = :id");
    query.setParameter("id", id);

    A a = (A) query.uniqueResult();

    query = getSession().createQuery("select new B(b.field1, b.field2, b.field3, b.field4) from B where b.A.id = :id");
    query.setParameter("id", id);

    List<B> bs = query.list();

    a.setListOfBs(bs);

    return a;
}