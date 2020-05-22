List<Operation> list = session.createCriteria(Operation.class)
    .add(Restrictions.or(
         Property.forName("class").eq(OpA2.class)
        ,Property.forName("class").eq(OpB1.class)
        ,Property.forName("class").eq(OpB3.class)
        ,Property.forName("class").eq(OpC.class)))
    .list();