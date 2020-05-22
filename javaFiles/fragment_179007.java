Criteria criteria = 
    session.createCriteria(Students.class)
           .add(Restrictions.eq("studentYear","2"))
           .add(Restrictions.eq("studentSemester","1"))
           .setProjection(Projections.distinct(Projections.property("studentHostel")));

List<String> listObj = criteria.list();
StringBuffer sb = new StringBuffer();
for(String str: listObj){
 sb.append(str+',');
}