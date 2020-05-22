return (SecurityMapped) getSession()
  .createCriteria(SecurityMapped.class)
  .add(Example.create(example))
  .setCacheable(true)
  .setCacheRegion("myregion")   // here you can choose region
  .uniqueResult();