public void create(T entity) {
   Session session=getSessionFactory().getCurrentSession();
   Transaction trans=session.beginTransaction();
   session.save(entity);
   trans.commit();
}