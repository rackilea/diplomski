Session session = getCurrentSession(); 

Criteria criteria = session.createCriteria(JobSeeker.class, "jobSeeker")
        .createAlias("jobSeeker.user","user") //default inner join
        .setFirstResult(dataTableFilter.iDisplayStart)
        .setMaxResults(dataTableFilter.iDisplayLength);
List<?> list = new ArrayList();
list = criteria.list();