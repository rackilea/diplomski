Criteria criteria = hibernateSession.createCriteria(MyClass);
Criterion rest1= Restrictions.and(Restrictions.eq(field1, value1), 
           Restrictions.eq(field2, value2),
           Restrictions.ne(field3, value3));
Criterion rest2= Restrictions.and(Restrictions.eq(field4, value4),
           Restrictions.eq(field5, value5));
criteria.add(Restrictions.or(rest1, rest2));