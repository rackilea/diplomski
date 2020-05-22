public Dog getDogAndOwnerById(Integer dogId) 
{
  Projection p=Projections.projectionList()
  .add(Projections.property("d.id"))//i dont need the alias anymore..
  .add(Projections.property("o.id"));
  Session session = getHibernateTemplate().getSessionFactory().openSession();        
  Criteria like = session.createCriteria(Dog.class,"d")
  .add(Restrictions.idEq(dogId)).setProjection(p)

  .setResultTransformer(new MyOwnTransformer())

  .setFetchMode("owner",FetchMode.JOIN).createAlias("owner","o");        
  Dog dog = (Dog)like.uniqueResult();        
  session.close();
  return dog;
}