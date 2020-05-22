CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery cq = cb.createQuery();
Root e = cq.from(Entity.class);
cq.where(cb.equal(e.type(), entityType));
Query query = em.createQuery(cq);
List<Entity> result = query.getResultList();