void updateNullBarField() {
  final Text DEFAULT_BAR = new Text("bar");

  PersistenceManagerFactory pmfInstance = JDOHelper
    .getPersistenceManagerFactory("transactions-optional");
  PersistenceManager pm = pmfInstance.getPersistenceManager();
  Query query = pm.newQuery(Foo.class);
  @SuppressWarnings("unchecked")
  Collection<Foo> foos = pm.detachCopyAll((List<Foo>) query.execute());

  for (Foo foo : foos) {
    if (foo.bar == null) {
      foo.bar = DEFAULT_BAR;
      pm.detachCopy(pm.makePersistent(foo));
    }
  }
}