PersistenceManager pm = ...;
try {
  Query quer = pm.newQuery("select from " + SomeObject.class.getName()
                          " where mField == mFieldParam" +
                          " parameters String mFieldParam");
  List<SomeObject> results = (List<SomeObject>) query.execute("Hosted by me");
} finally {
  ...
}