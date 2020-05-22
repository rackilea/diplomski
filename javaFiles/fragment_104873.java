String sQuery = "select min(myEntity.x), max(myEntity.y) from MyEntity myEntity";
Query hQuery = session.createQuery(sQuery);
List result = hQuery.list();

Iterator iterator = result.iterator();

while (iterator.hasNext()) {
    Object[] row = (Object[])iterator.next();
    for (int col = 0; col < row.length; col++) {
        System.out.println(row[col]);
    }
}