public Long count() {  
    String sql = "SELECT COUNT(t.task_id_t100) from T100_TASK t ";  
    Query query = entityManager.createNativeQuery(sql);  
    Object o = query.getSingleResult(); 
    //for BigDecimal
    if (o.getClass().equals(BigDecimal.class) ){
        BigDecimal big = (BigDecimal) o;
        return handleBigDecimal(big); //TODO
    }
    //other types might follow
    return (Long) o;  
}