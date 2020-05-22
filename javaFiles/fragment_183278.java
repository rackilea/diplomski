public static Parent getParentWithChildrenById(int id) {
  Session session = HibernateUtil.getSessionFactory().openSession();
  Parent entity = (Parent) session.get(ParentEntity.class, id);
  Hibernate.initialize(entity.children);
  session.close();
  return entity;
}