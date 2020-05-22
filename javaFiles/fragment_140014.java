List<UUID> uuids = new ArrayList<UUID>();
uuids.add(UUID.fromString("..."));

Query query = session.createQuery(queryString);
// **This method setParameterList bind multiple values to a named query parameter.**
query.setParameterList("uuids", uuids);

List list = query.list();