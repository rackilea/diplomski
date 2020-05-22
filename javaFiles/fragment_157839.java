final List result = currentSession()
        .createSQLQuery("SELECT id as id,c03 as c03,c34 as c34 " + 
                         "FROM (SELECT id,c34,c03 FROM students " + 
                               "where c34 in(:filters) " + 
                               "order by id desc) o group by c34")
        .setParameterList("filters",Arrays.asList(74,1812))
        .addScalar("id",org.hibernate.type.IntegerType.INSTANCE)
        .addScalar("c03",org.hibernate.type.DateType.INSTANCE)
        .addScalar("c34",org.hibernate.type.DateType.INSTANCE)
        .setResultTransformer(Transformers.aliasToBean(Student.class))
        .list();