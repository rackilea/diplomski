List<Object[]> executeObjects = null;
Query query = mgr.createNativeQuery("SQL Query");
executeObjects = (List<Object[]>) query.getResultList();

for (Object[] object : executeObjects) {
    Long id = new Long((Integer) object[0]);
    Long id2 = new Long((Integer) object[1]);
    String desc = (String) object[2];
    ...
    ...
}