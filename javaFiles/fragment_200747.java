DatastoreService datastore = DatastoreServiceFactory
 .getDatastoreService();
List<Foo> results = new ArrayList<Foo>();

Query query = new Query("Foo", KeyFactory.stringToKey(""));
List<Entity> entities = datastore.prepare(query).asList(
  FetchOptions.Builder.withDefaults());

for (Entity entity : entities) {
  results.add(new Foo(entity));
}