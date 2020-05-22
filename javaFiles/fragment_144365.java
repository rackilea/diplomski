List<String> listMoreThan1000 = ...;
int size = 1000;
Collection<List<String>> split = partition(listMoreThan1000, size);
String inClause = "", or = "";
for (int i = 0; i < split.size(); i++) {
    inClause += or + "r.uid in ?" + i;
    or = " OR ";
}
String query = String.format("SELECT r.subject, COUNT(DISTINCT ss.id), COUNT(DISTINCT r.uid)" +
        " FROM %s r, %s ss" +
        " WHERE r.id = ss.id" +
        " AND %s GROUP BY r.subject", R.class.getName(), SS.class.getName(), inClause);

Query query = session.createQuery(query);
for (int i = 0; i < split.size(); i++) {
    query.setParameter("?" + i, split.get(i));
}

List<Object[]> rows = query.list();