// construct a hibernate query using named query, specifying the type parameter.
Query query = session.getNamedQuery("FieldEntity.findByType").setString("type", type);

// Now iterate and capture results
List<FieldEntity> results = new ArrayList<>();
for(Object[] row : query.list()) {
  FieldEntity e = row.get(0);
  results.add(e);
}