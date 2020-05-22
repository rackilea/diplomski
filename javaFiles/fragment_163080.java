CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Dates> query = cb.createQuery(Dates.class);

Root<Dates> root = query.from(Dates.class);
Join<Dates, DateInfo> infos = root.join("dates", JoinType.LEFT);

query.distinct(true);
em.createQuery(query.where(cb.between(infos.<Integer>get("id"), 1, 10))).getResultList();