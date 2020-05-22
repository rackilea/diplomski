List<Object[]> rows = query.list();
for (Object[] row : rows) {
    Integer franchiseId = (Integer) row[0];
    Integer resellerId = (Integer) row[1];
    // ...
}