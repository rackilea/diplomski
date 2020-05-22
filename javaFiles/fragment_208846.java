List<Operation> list = session.createCriteria(Operation.class)
    .add(Restrictions.or(
        Restrictions.and(Property.forName("class").eq(OpA2.class), Restrictions.eq("f", 1))
        , Property.forName("class").eq(OpB1.class)
        , Property.forName("class").eq(OpB3.class)
        , Restrictions.and(Property.forName("class").eq(OpC.class), Restrictions.eq("value", "b"))))
    .list();