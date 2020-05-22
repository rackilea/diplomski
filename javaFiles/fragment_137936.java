Criteria criteria = session.createCriteria(Name.class, "name")
   .add(Restrictions.disjunction()
      .add(Restrictions.ilike("name.fname", fname + "%"))
      .add(Restrictions.ilike("name.fname", "%" + " " + fname + "%")))
   .setProjection(Projections.property("name.fname").as("fname"))
   .add(Restrictions.sqlRestriction("1 = 1", fname + "%", StringType.INSTANCE))
   .addOrder(new FirstNameOrder())
   .addOrder(Order.asc("fname"));