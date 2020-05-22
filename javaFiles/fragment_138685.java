public int getActiveCountOfList(long list_id) {
    String sql = "SELECT COUNT(*) FROM TABLE_2 t2 
                 LEFT JOIN TABLE_3 t3 ON t2.ITEM_ID = t3.ITEM_ID 
                 WHERE t2.LIST_ID = :list_id AND t3.LETTER IN ('A', 'B')
                 AND t3.STATUS = 'ACTIVE'";

    Object result = session.createSqlQuery(sql).setLong("list_id", list_id)
                       .uniqueResult();

    return ((Number) result).intValue();
}