CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Object> cq = cb.createQuery();
Root<Snapshot> r = cq.from(Snapshot.class);
cq.where(cb.equal(r.get("systemID"), systemID));
cd.orderBy(cb.desc(r.get("id")));
em.createQuery(cq).geFirsttResult();