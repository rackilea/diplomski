List<Entity> getRandomEntities() {
   DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

  Query queryForEntities = new Query("Entity");

  PreparedQuery preppedEntityQuery = datastore.prepare(q);
  return preppedEntityQuery.asList(FetchOptions.Builder.withOffset([OFFSET_YOU_WANT]).withLimit([AMOUNT_YOU_WANT]));
}