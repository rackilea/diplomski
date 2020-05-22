public List<eresa> getDetailparDateArrive(Date date) {
        // TODO Auto-generated method stub
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
    //  Query req=session.createQuery("from eresa e inner join dresa d on e.f_ideResa = d.eresa.f_ideResa and e.F_DATEFROM=:x  ");
        Query req=session.createQuery("from eresa e, dresa d where e.F_DATEFROM=:x and e.f_ideResa = d.eresa.f_ideResa ");
        req.setParameter("x", date);
        return req.list();
    }