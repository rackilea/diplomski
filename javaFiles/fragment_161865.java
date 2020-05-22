List<Object[]> rows = query.getResultList();
List<MyObject> result = new ArrayList<>(rows.size());
for (Object[] row : rows) {
    result.add(new MyObject((String) row[0],
                            (Long) row[1],
                            ...));
}