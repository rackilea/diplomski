//In Java
criteria.add(
    Restrictions.or(
         Restrictions.isNotNull("status"),
         Restrictions.and(
           Restrictions.eq("anotherFilter",anotherFilterValue),
           Restrictions.isNull("status")
         )
    )
);