try{
    String MYQUERY = "select DISTINCT lower(column1) as col1 from TABLE order by col1 asc";

    List<(Object)> myList = null;
    SQLQuery query = getSession().createSQLQuery(MYQUERY);
    query.setResultTransformer(Transformers.aliasToBean(className));
    query.addScalar("col1", StandardBasicTypes.STRING);
    myList = query.list();
} catch (HibernateException e) {
    System.out.println(e);
}