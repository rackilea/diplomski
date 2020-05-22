StringBuffer sql = new StreingBuffer();  
sql.append("select p.name as name, s.level as level from 
person p
    join student s on s.pk_seq = p.fk_student ; ");


SQLQuery query = getSession().createSQLQuery(sql.toString());
query.setResultTransformer(Transformers.aliasToBean(ObjectPR.class));

List<ObjectPR> results = query.list();