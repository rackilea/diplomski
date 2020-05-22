public void fetchinfo(String email) {

    String hql = "select s from student s where s.email = :email";

    return (Student)sessionFactory.getCurrentSession().createSQLQuery(hql)
      .setParameter("email", email).uniqueResult();

}