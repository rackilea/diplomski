CriteriaBuilder builder = em.getCriteriaBuilder();
CriteriaQuery<Aa> criteria = builder.createQuery(Aa.class);
Root<Aa> a = criteria.from(Aa.class);
CollectionJoin<Aa, Bb> b = a.join(Aa_.listBb);
CollectionJoin<Bb, Cc> c = b.join(Bb_.listCc);
criteria.where(builder.equal(c.get(Cc_.id), cId));
return em.createQuery(criteria).getResultList();