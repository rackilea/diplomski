session.beginTransaction();
Criteria criteria = session.createCriteria(Departement.class);
criteria.add(Restrictions.eq("nomDepartement", nomDepartement).ignoreCase());

 result = (Departement) criteria.uniqueResult();
 session.getTransaction().commit();