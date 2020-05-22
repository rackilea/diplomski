public List<CustomerProfile> findAll(){
        List<CustomerProfile> list_cust = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM CustomerProfile";
        try{
            session.beginTransaction();
            list_cust = session.createQuery(sql).list();
            for (CustomerProfile cp : list_cust) {
                Hibernate.initialize(cp.getCustomer());
                //or cp.getCustomer().getLoginName();
            }
            session.beginTransaction().commit();
        }catch(Exception e){
            session.beginTransaction().rollback();
        }
        return list_cust;
    }