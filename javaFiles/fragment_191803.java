public boolean exists(Long id)

{

    String queryString="select id from test where testid= "+id;
    Query query = entityManagerUtil.entityManager.createNativeQuery(queryString);
    if (query.list().size()>0){ 
       return true
    }

    return false
}