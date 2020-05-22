String nativeSQL = "SELECT T2.* FROM TABLE1 T1, TABLE2 T2 WHERE T1.USERID = 'TESTUSER'    AND T2.GROUP_CAT IN (T1.GROUPCAT1,T1.GROUPCAT2,T1.GROUPCAT3,T1.GROUPCAT4, T1.GROUPCAT5)";

Query q=this.getEntityManager().createNativeQuery(nativeSQL,T2Entity.class);

try{
    List<T2Entity> t2EntityList  = (List<T2Entity>) q.getResultList();
    return t2EntityList;
}catch(NoResultException e){
    return null;
}