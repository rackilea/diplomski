Query q = em.createNativeQuery(querySBuilder.toString());
List<Object[]> result = q.getResultList();

for (Object[] row : result) {
    int id = (Integer)row[0];
    String statusName = (String)row[1];

    // do something with the id and statusName from above
}