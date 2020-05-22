// final EntityType<Meaning> Meaning_ = em.getMetamodel().entity(Meaning.class); 
final CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
final Root<Meaning> meng = cq.from(Meaning.class);
cq.where(meng.get(Meaning_.lastPublishedDate)); // add the appropriate import 
cq.select(meng.get(Meaning_.objId));            
TypedQuery<Integer> q = em.createQuery(cq); 
return q.getResultList();