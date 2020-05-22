private static Key getKeyForCity(String uniqueID, String city) {

    Key ancestorKey = KeyFactory.createKey("User", uniqueID);

    Query query = new Query("Trip", ancestorKey);
    query.addFilter("city", FilterOperator.EQUAL, city);
    Entity trip = datastore.prepare(query).asSingleEntity();

    return trip.getKey();
}