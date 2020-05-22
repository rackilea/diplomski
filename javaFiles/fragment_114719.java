public org.hibernate.Criteria getCriteria() {

    HibernateEntityManager hem = em.unwrap(HibernateEntityManager.class);
    org.hibernate.Session session = hem.getSession();

 if(session.isOpen())
{
return session.createCriteria(getEntityBeanType())
}

    return null;
}